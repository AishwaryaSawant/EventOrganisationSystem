/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.controller;

import com.eventorg.dao.CustomerDAO;
import com.eventorg.dao.DAO;
import com.eventorg.dao.EventOrderDAO;
import com.eventorg.dao.FoodDAO;
import com.eventorg.dao.LocationDAO;
import com.eventorg.dao.OwnerDAO;
import com.eventorg.dao.VenueDAO;
import com.eventorg.dao.WorkerDAO;
import com.eventorg.pojo.Customer;
import com.eventorg.pojo.EventOrder;
import com.eventorg.pojo.Food;
import com.eventorg.pojo.Location;
import com.eventorg.pojo.Owner;
import com.eventorg.pojo.Venue;
import com.eventorg.pojo.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;

/**
 *
 * @author aishw
 */
public class EventOrganisationController extends AbstractController{
    public EventOrganisationController() {
    }
    
    static Logger log = Logger.getLogger(EventOrganisationController.class.getName());
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;

        String option= request.getParameter("email") == null ? "" : request.getParameter("email");
        HttpSession sess = request.getSession();
//        
//        
//          DAO d; // = new OwnerDAO();'
        //String user = null;
        //String user = null;
        OwnerDAO o = new OwnerDAO();
        CustomerDAO c = new CustomerDAO();
        WorkerDAO w = new WorkerDAO();
        LocationDAO l = new LocationDAO();
        FoodDAO f = new FoodDAO();
        VenueDAO v = new VenueDAO();
        EventOrderDAO e = new EventOrderDAO();
        
        Owner owner =null;
        Customer customer = null;
        Worker worker = null;
        EventOrder eventorder = null;
        
        Set<Worker> workersorder = new HashSet();
        Set<Food> foodsorder = new HashSet();
        
        Venue venue = null;
        
        double discount = 0;
        double calculate = 0;
//        Owner user = null;
       // if (option == null || option == "") {
            //System.out.println("Name" + request.getAttribute("fname"));
            
         try{
            if(request.getRequestURI().equals("/EventOrganisationSystem/EventOrganisationLogin.htm")){                
                mv = new ModelAndView("EventOrganisationLogin");
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventUserReg.htm")){
//                String keyword = request.getParameter("keyword");
//                List<Movie> list = md.getMovie(keyword);
//                mv = new ModelAndView("getMovies","movies",list);
                mv = new ModelAndView("EventUserReg");
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventUserAdd.htm")){
                //System.out.println("Title: " + request.getAttribute("title"));
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String password = request.getParameter("password");
                String address = request.getParameter("address");
                String phoneNumber = request.getParameter("phonenumber");
                String email = request.getParameter("email");      
                String photoPath = request.getParameter("photopath");
                String userType = request.getParameter("usertype");
                
                
                List<String> emails = new ArrayList();
                for(Owner owner1 : o.getAllOwners()){
                    emails.add(owner1.getEmail());
                }
                for(Customer cust1 : c.getAllCusts()){
                    emails.add(cust1.getEmail());
                }
                for(Worker work1 : w.getAllWorkers()){
                    emails.add(work1.getEmail());
                }
                
                if(emails.contains(email)){
                    String msg = "Email already exists enter another email";
                    mv = new ModelAndView("EventUserReg","message",msg);
                }else{
                    if(userType.equals("Owner")){
//                    OwnerDAO md = new OwnerDAO();
//                    o = md;
//                    o = new OwnerDAO();
                    Set<Venue> ven = new HashSet<>();
                    Set<Worker> wor = new HashSet<>();
                    Set<Food> foo = new HashSet<>();
                    
                    int result = o.addOwner(firstName, lastName, password, address, phoneNumber, email, photoPath,ven,wor,foo);//, userType);
                    if(result == 1 ){
                        sess.setAttribute("user",owner);
                        String msg ="Owner has been created successfully";
                        
                        //mv = new ModelAndView("EventOwnerHomePage");
                        mv = new ModelAndView("success","message", msg);
                    }
                }else if(userType.equals("Customer")){
//                    CustomerDAO md = new CustomerDAO();
//                    c=md;
//                    c = new CustomerDAO();
                    int result = c.addCustomer(firstName, lastName, password, address, phoneNumber, email,photoPath);//, userType);
                    if(result == 1 ){
                        String msg ="Customer has been created successfully";
                        mv = new ModelAndView("success","message", msg);
                    }
                
                }else if(userType.equals("Worker")){
//                    WorkerDAO md = new WorkerDAO();
//                    w=md;
//                    w = new WorkerDAO();

                    sess.setAttribute("worker", worker);
                    Worker wor = w.addWorker(firstName, lastName, password, address, phoneNumber, email,photoPath,true,(Owner)sess.getAttribute("user"));//, userType);
                    Owner ow = o.getOwner(((Owner)sess.getAttribute("user")).getOid());
                    Set<Worker> s = ow.getWorkers();
                    s.add(wor);
                    if(wor == null){
                        mv = new ModelAndView("error", "message", "Not able to create user account");
                        
                    }else{
                    String msg ="Worker has been created successfully";
                    mv = new ModelAndView("success","message", msg);
                }
                }
                }
//                HashSet venueSet= new HashSet();
//                HashSet workerSet= new HashSet();
//                HashSet foodSet= new HashSet();
            
       
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventLoginCheck.htm")){
                //System.out.println("Title: " + request.getAttribute("title"));
//                session.setAttribute(option, request.getParameter("email"));
                String email = request.getParameter("email");//session.getAttribute(option).toString(); // //valid email : a,w,c
                String password = request.getParameter("password");  //valid pwd : a,w,c
//                System.out.println("Email"+email);
//                System.out.println(password);
                owner = o.getOwner(email, password);
                customer = c.getCustomer(email, password);
                worker = w.getWorker(email, password);
                
                if(owner!=null){
                    sess.setAttribute("user", owner);
                  // sess.setAttribute(name, owner.getFirstname());
                    String msg = "Welcome "+owner.getFirstname();
                    log.info(owner.getFirstname()+" has logged in with "+owner.getEmail());
                    //mv = new ModelAndView("");
                    mv = new ModelAndView("EventOwnerHomePage");//,"sess",sess);
                
                }else if(customer!=null){
                    
                    sess.setAttribute("usercust", customer);
                    String msg = "Welcome "+customer.getFirstname();
                    log.info(customer.getFirstname()+" has logged in with "+customer.getEmail());
//                    List<Location> lo = l.getLocations();
//                    List<Food> fo = f.getFoods();
//                    sess.setAttribute("listLocation", lo);
//                    sess.setAttribute("listFood", fo);
                    
//                    mv = new ModelAndView("EventOrderStart","venlist",venues);
                    mv = new ModelAndView("EventCustomerHomePage");
                    //mv = new ModelAndView("success","message", msg);
                }else if(worker!=null){
                    
                    sess.setAttribute("userwork", worker);
                    String msg = "Welcome "+worker.getFirstname();
                    log.info(worker.getFirstname()+" has logged in with "+worker.getEmail());
                    Set<EventOrder> orderlist = worker.getEventorders();
                    mv = new ModelAndView("EventWorkerHomePage","orderlist",orderlist);
                    //mv = new ModelAndView("success","message", msg);
                }else if(email.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
                    //System.out.println("in admin");
                    mv = new ModelAndView("EventAdminHomePage");
                    //sess.setAttribute(user, worker);
//                    String msg = "Welcome "+worker.getFirstname();
//                    mv = new ModelAndView("EventWorkerHomePage");
//                    mv = new ModelAndView("success","message", msg);
                }else{
                    String msg="Please enter valid credentials";
                    //log.info("Failed login attempt with email: "+email+" and password: "+password);
                    mv = new ModelAndView("EventOrganisationLogin","msg",msg);
                }
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventAdminRequest.htm")){
                String req = request.getParameter("addAdmin");
                if(req.equalsIgnoreCase("addAdminLocation")){
                    mv = new ModelAndView("EventAdminAddLocation");
                }else if(req.equalsIgnoreCase("addAdminFood")){
                    mv = new ModelAndView("EventAdminAddFood");
                }else if(req.equalsIgnoreCase("UpdateOwner")){
                    List<Owner> ownerlist = o.getAllOwners();
                    mv = new ModelAndView("EventAdminViewOwner","listOwners",ownerlist);
                }
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventAdminAddedFood.htm")){
                String name = request.getParameter("foodname");
                String type = request.getParameter("foodtype");
                int serveCapacity = Integer.parseInt(request.getParameter("capacity"));
                double price = Double.parseDouble(request.getParameter("price"));
                
                int result = f.addFood(name, type, serveCapacity, price);
                if(result==1){
                    String msg ="Food has been added successfully";
                    mv = new ModelAndView("success","message", msg);
                }else{
                    mv = new ModelAndView("error", "message", "Not able to add new Food");
                }
                    
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventAdminAddedLoc.htm")){
                String location = request.getParameter("location");
//                Location loc = new Location();
//                loc.setName(location);
                boolean flag = false;
                List<Location> listloc= l.getLocations();
                for(Location lo : listloc){
                    if(lo.getName().equalsIgnoreCase(location)){
                        flag=true;
                    }
                }
                if(flag==true){
                      mv = new ModelAndView("error", "message", "Location already exist, unable to add!");

                }else if(flag==false){
                    int result = l.addLocation(location);
                    String msg ="Location has been added successfully";
                    mv = new ModelAndView("success","message", msg);
                }
               
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOrderDel.htm")){
                //long id = Long.parseLong(request.getParameter("id"));
                 long id = Long.parseLong(request.getParameter("id"));
                 EventOrder ev = e.getEventOrderById(id);

                Customer cust = (Customer)sess.getAttribute("usercust");
                String title = "Request for Updating Order";
                String msgBody = "Hi, customer: "+cust.getFirstname()+" ,has requested a change in order, EventName: "+ev.getEventname()+" Status: "+ev.getStatus()+" Dateofevent: "+ev.getDateofevent();
                String from = "evento2494@gmail.com";  //get worker and fetch emailid
                String to = "aishwaryasawant697@gmail.com"; //get owner and fetch emailid but for demo 
                boolean mailStatus = EventMailController.sendEmail(from, to, msgBody, title);
                ev.setStatus("Customer requested change");
                e.updateEventOrder(ev);
                if(mailStatus == true){
                    String msg ="Update request has been submitted successfully.Please wait for approval.";
//                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                     mv = new ModelAndView("success","message", msg);
                }else{
                     mv = new ModelAndView("error", "message", "Not able to send update request");
                }
                    
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOrderStartAgain.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                
                EventOrder ev = e.getEventOrderById(id);
                if(ev.getStatus().equalsIgnoreCase("placed")){
                    ev.setStatus("Closed");
                    e.updateEventOrder(ev);
                    List<Venue> venues = v.getAllVenues();
                    System.out.println("ven "+venues);
                    mv = new ModelAndView("EventOrderStart","venlist",venues);
                }else{
                    String msg="Order cannot be replaced,updated once its completed or closed";
                     mv = new ModelAndView("EventOrderView","msg",msg);
                }  
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOrderDel.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                
                EventOrder ev = e.getEventOrderById(id);
                if(!ev.getStatus().equalsIgnoreCase("Closed") && !ev.getStatus().equalsIgnoreCase("Completed") && !ev.getStatus().equalsIgnoreCase("NotEditable")){
                    ev.setStatus("Closed");
                    e.updateEventOrder(ev);
                    List<Venue> venues = v.getAllVenues();
                    System.out.println("ven "+venues);
                    mv = new ModelAndView("EventOrderStart","venlist",venues);
                }else{
                    List<EventOrder> eventorderlist = e.getEventOrdersById(((Customer)sess.getAttribute("usercust")).getCid());
                    
                    String msg="Order cannot be replaced,updated once its completed or closed";
                    sess.setAttribute("me",msg);
                    mv = new ModelAndView("EventOrderView","orderlist",eventorderlist);
                }  
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOrderUp.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                
                EventOrder ev = e.getEventOrderById(id);
                if(!ev.getStatus().equalsIgnoreCase("Closed") && !ev.getStatus().equalsIgnoreCase("Completed") && !ev.getStatus().equalsIgnoreCase("NotEditable")){
                ev.setStatus("placed");
                String title = "Request for Change in Order";
                String msgBody = "Hi, customer: "+((Customer)sess.getAttribute("usercust")).getFirstname()+" ,has requested a change in event, Name: "+ev.getEventname()+" Status: "+ev.getStatus()+" Dateofevent: "+ev.getDateofevent();
                String from = "evento2494@gmail.com";  //get worker and fetch emailid
                String to = "aishwaryasawant697@gmail.com"; //get owner and fetch emailid but for demo 
                boolean mailStatus = EventMailController.sendEmail(from, to, msgBody, title);
                //ev.setStatus("Customer requested change");
                e.updateEventOrder(ev);
                if(mailStatus == true){
                    String msg ="Change request has been submitted successfully";
//                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                     mv = new ModelAndView("success","message", msg);
                }else{
                     mv = new ModelAndView("error", "message", "Not able to send change request");
                }
                    
                }else{
                    String msg="Order cannot be replaced,updated once its completed or closed";
                     mv = new ModelAndView("EventOrderView","msg",msg);
                }  
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOrderWorkerChange.htm")){
                EventOrder eve = e.getEventOrderById(Long.parseLong(request.getParameter("id")));
                Worker wor = (Worker)sess.getAttribute("userwork");
                String title = "Request for Change in Assignment";
                String msgBody = "Hi, worker: "+((Worker)sess.getAttribute("userwork")).getFirstname()+" ,has requested a change in event, Name: "+eve.getEventname()+" Status: "+eve.getStatus()+" Dateofevent: "+eve.getDateofevent();
                String from = "evento2494@gmail.com";  //get worker and fetch emailid
                String to = "aishwaryasawant697@gmail.com"; //get owner and fetch emailid but for demo 
                boolean mailStatus = EventMailController.sendEmail(from, to, msgBody, title);
                eve.setStatus("Worker requested change");
                e.updateEventOrder(eve);
                if(mailStatus == true){
                    String msg ="Change request has been submitted successfully";
//                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                     mv = new ModelAndView("success","message", msg);
                }else{
                     mv = new ModelAndView("error", "message", "Not able to send change request");
                }

            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventFoodDel.htm")){
                Food food2 = f.getFood(Long.parseLong(request.getParameter("id")));
                food2.getOwners().remove((Owner)sess.getAttribute("user"));
                f.updateFood(food2);
                ((Owner)sess.getAttribute("user")).getFoods().remove(food2);
                int result = o.updateOwner((Owner)sess.getAttribute("user"));
                
                if(result==1){
                     String msg ="Food has been deleted successfully from your List";
                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                     mv = new ModelAndView("success","message", msg);
                }else{
                     mv = new ModelAndView("error", "message", "Not able to delete food");
                }
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventSystemLogout.htm")){
                sess.invalidate();
                mv = new ModelAndView("EventOrganisationLogin");
            }
            else{
                mv = new ModelAndView("EventOrganisationLogin");
            }       
            }catch(Exception except){
                System.out.println("except:" +except);
                mv = new ModelAndView("EventOrganisationLogin");
            }
        return mv;
        
    }
}
