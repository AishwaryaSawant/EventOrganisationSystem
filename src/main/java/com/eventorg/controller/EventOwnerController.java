
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
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
/**
 *
 * @author aishw
 */
public class EventOwnerController extends AbstractController{
     public EventOwnerController() {
    }
        
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        HttpSession sess = request.getSession();
        
        
        
        OwnerDAO o = new OwnerDAO();
        CustomerDAO c = new CustomerDAO();
        WorkerDAO w = new WorkerDAO();
        LocationDAO l = new LocationDAO();
        FoodDAO f = new FoodDAO();
        VenueDAO v = new VenueDAO();
        EventOrderDAO e = new EventOrderDAO();
        
        Owner owner = new Owner();
        Customer customer = null;
        Worker worker = null;
        EventOrder eventorder = null;
        
        List<EventOrder> listCompleted = new ArrayList();
        List<EventOrder> listClosed = new ArrayList();
        List<EventOrder> getAll = new ArrayList();
        List<Venue> venList  = new ArrayList();
        
        Set<Worker> workersorder = new HashSet();
        Set<Food> foodsorder = new HashSet();
        
        Venue venue = new Venue();
        
        double discount = 0;
        double calculate = 0;
        if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwner.htm")){
//                System.out.println("session "+session.getAttribute(option));
                String op = request.getParameter("optionAdd");              
                if(op.equalsIgnoreCase("addPlace")){
                    List<Location> lo = l.getLocations();
                    mv = new ModelAndView("EventAddVenue","listLocation",lo);//,"Location",locations);
                }else if(op.equalsIgnoreCase("addFood")){
                    List<Food> fo = f.getFoods();
                    System.out.println("fo: "+fo);
                    mv = new ModelAndView("EventAddFood","listFood",fo);
                }if(op.equalsIgnoreCase("addWorker")){
                    mv = new ModelAndView("EventAddWorker");
                }
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerView.htm")){
                String op = request.getParameter("optionView");
                if(op.equalsIgnoreCase("viewPlaces")){
                    //System.out.println("View"+((Owner)sess.getAttribute("user")).getFirstname());
                    Set<Venue> venuelist = ((Owner)sess.getAttribute("user")).getVenues();//o.getOwner(((Owner)sess.getAttribute("user")).getOid())//v.getVenues((Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventViewVenue","listVenues",venuelist);
                }else if(op.equalsIgnoreCase("viewWorkers")){
                    System.out.println("worker view: "+((Owner)sess.getAttribute("user")).getFirstname());
                    Set<Worker> workerlist = ((Owner)sess.getAttribute("user")).getWorkers();//o.getOwner(((Owner)sess.getAttribute("user")).getOid())//v.getVenues((Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventViewWorker","listWorkers",workerlist);
                }else if(op.equalsIgnoreCase("viewFoods")){
                    System.out.println("Food view: "+((Owner)sess.getAttribute("user")).getFirstname());
                    Set<Food> foodlist = ((Owner)sess.getAttribute("user")).getFoods();//o.getOwner(((Owner)sess.getAttribute("user")).getOid())//v.getVenues((Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventViewFood","listFoods",foodlist);
                }
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerSubmit.htm")){
                //System.out.println("temppppppp");
                Set<Date> venassign = new TreeSet();
                String venueName = request.getParameter("venueName");
                int id = Integer.parseInt(request.getParameter("location"));
                Location lo = l.getLocation(id);
                //Location inputLocation = (Location)request.getParameter("location");
                int inputCapacity = Integer.parseInt(request.getParameter("inputCapacity"));
                double inputPrice = Double.parseDouble(request.getParameter("inputPrice"));
                boolean avail = Boolean.parseBoolean(request.getParameter("avail"));
                boolean negotiate = Boolean.parseBoolean(request.getParameter("negotiate"));
                venue = new Venue();
                venue.setPlacename(venueName);
                venue.setLocation(lo);
                venue.setCapacity(inputCapacity);
                venue.setPrice(inputPrice);
                venue.setIsavailable(avail);
                venue.setIsnegotiable(negotiate);
                venue.setOwner((Owner)sess.getAttribute("user"));
                v = new VenueDAO();
                int result = v.addVenue(venue);
                //venue = v.addVenue(venueName, lo, inputCapacity, inputPrice, avail, negotiate, (Owner)sess.getAttribute("user"));
                if(result!=1){
                   mv = new ModelAndView("error", "message", "Not able to add new venue");
                }else{
                    Owner ow = o.getOwner(((Owner)sess.getAttribute("user")).getOid());
                    Set<Venue> s = ow.getVenues();
                    s.add(venue);
                    String msg ="Venue has been added successfully";
                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                    mv = new ModelAndView("success","message", msg);
                }
                //mv = new ModelAndView("");
//                String 
//             
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventVenueUp.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                System.out.println("id "+id);
                venue = v.getVenue(id);
                System.out.println("Venue up: "+venue.getPlacename());
                List<Location> lo = l.getLocations();
                //sess.setAttribute("locationList", lo);
                //sess.setAttribute("venue", venue);
                mv = new ModelAndView("EventVenueUpdate","venue",venue);
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventVenueUpdated.htm")){
                //System.out.println("temppppppp");
                
                String venueName = request.getParameter("placename");
                long id = Long.parseLong(request.getParameter("oid"));
                Location lo = l.getLocation(id);
                //Location inputLocation = (Location)request.getParameter("location");
                int inputCapacity = Integer.parseInt(request.getParameter("capacity"));
                double inputPrice = Double.parseDouble(request.getParameter("price"));
                boolean avail = Boolean.parseBoolean(request.getParameter("avail"));
                boolean negotiate = Boolean.parseBoolean(request.getParameter("nego"));
                v = new VenueDAO();
                int result = v.updateVenue(id, venueName, inputCapacity, inputPrice, avail, negotiate);//, (Owner)sess.getAttribute("user"));
                if(result == 1){
                     String msg ="Venue has been updated successfully";
                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                    mv = new ModelAndView("success","message", msg);
                   
                }else{
//                    Owner ow = o.getOwner(((Owner)sess.getAttribute("user")).getOid());
//                    Set<Venue> s = ow.getVenues();
//                    s.add(venue);
                   mv = new ModelAndView("error", "message", "Not able to update venue");
                }
                //mv = new ModelAndView(""); EventVenueDel
//                String 
//             
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventVenueDel.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                System.out.println("iddddd "+id);
                venue = v.getVenue(id);
                int result = v.deleteVenueById(id);
                ((Owner)sess.getAttribute("user")).deleteVenue(venue);
                if(result==1){
                     String msg ="Venue has been deleted successfully";
                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                    mv = new ModelAndView("success","message", msg);
                }else{
                   mv = new ModelAndView("error", "message", "Not able to delete venue");
                }
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerUp.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                System.out.println("id "+id);
                owner = o.getOwner(id);
                //System.out.println("Venue up: "+venue.getPlacename());
                //List<Location> lo = l.getLocations();
                //sess.setAttribute("locationList", lo);
                //sess.setAttribute("venue", venue);
                mv = new ModelAndView("EventOwnerUpdate","owner",owner);
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerUpdated.htm")){
                //System.out.println("temppppppp");
                
                String firstname = request.getParameter("firstname");
                long id = Long.parseLong(request.getParameter("oid"));
                //Location lo = l.getLocation(id);
                //Location inputLocation = (Location)request.getParameter("location");
                String lastname = request.getParameter("lastname");
                String password = request.getParameter("lastname");
                String address = request.getParameter("address");
                String phonenumber = request.getParameter("phonenumber");
                String email = request.getParameter("email");
                //v = new OwnerDAO();
                int result = o.updateOwner(id, firstname, lastname, password, address, phonenumber, email);
                if(result == 1){
                     String msg ="Owner has been updated successfully";
                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                    mv = new ModelAndView("success","message", msg);
                   
                }else{
//                    Owner ow = o.getOwner(((Owner)sess.getAttribute("user")).getOid());
//                    Set<Venue> s = ow.getVenues();
//                    s.add(venue);
                   mv = new ModelAndView("error", "message", "Not able to update owner");
                }
                //mv = new ModelAndView(""); EventVenueDel
//                String 
//             
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerDel.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                owner = o.getOwner(id);
                //v.deleteVenueByOwner(owner);
                int result = o.deleteOwnerById(id);
                
                // many to many delete
                //((Owner)sess.getAttribute("user")).deleteVenue(venue);
                if(result==1){
                     String msg ="Owner has been deleted successfully";
                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                    mv = new ModelAndView("success","message", msg);
                }else{
                   mv = new ModelAndView("error", "message", "Not able to delete owner");
                }
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventWorkerUp.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                System.out.println("id "+id);
                worker = w.getWorker(id);
//                System.out.println("Venue uup: "+venue.getPlacename());
//                List<Location> lo = l.getLocations();
                //sess.setAttribute("locationList", lo);
                //sess.setAttribute("venue", venue);
                mv = new ModelAndView("EventWorkerUpdate","worker",worker);
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventWorkerUpdated.htm")){
                //System.out.println("temppppppp");
                long id = Long.parseLong(request.getParameter("id"));
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String address = request.getParameter("address");
                String phno = request.getParameter("phonenumber");
                Boolean avail = Boolean.parseBoolean(request.getParameter("avail"));
                w = new WorkerDAO();
                int result = w.updateWorker(id,fname,lname,email,password,address,phno,avail);//, (Owner)sess.getAttribute("user"));
                if(result == 1){
                     String msg ="Worker has been updated successfully";
                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                    mv = new ModelAndView("success","message", msg);
                   
                }else{
//                    Owner ow = o.getOwner(((Owner)sess.getAttribute("user")).getOid());
//                    Set<Venue> s = ow.getVenues();
//                    s.add(venue);
                   mv = new ModelAndView("error", "message", "Not able to update worker");
                }
                //mv = new ModelAndView(""); EventVenueDel
//                String 
//             
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventWorkerDel.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                worker = w.getWorker(id);
                int result = w.deleteWorkerById(id);
                ((Owner)sess.getAttribute("user")).deleteWorker(worker);
                if(result==1){
                     String msg ="Worker has been deleted successfully";
                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                    mv = new ModelAndView("success","message", msg);
                }else{
                   mv = new ModelAndView("error", "message", "Worker cannot be deleted as already assigned to an event");
                }
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerFoodSubmit.htm")){
                //System.out.println("temppppppp");
//                Set<Owner> h = new HashSet();
//                h.add((Owner)sess.getAttribute("user"));
                String[] idarr = request.getParameterValues("foodname");
                for(String id: idarr){
                    System.out.println("id: "+id);
                }
                Set<Food> foo = new HashSet();
                Owner ow = (Owner)sess.getAttribute("user");
                System.out.println("Owner "+ow);
                //Set<Owner> ow = new HashSet();
                Food food = new Food();
                for(int i=0;i<idarr.length;i++){
                    foo.add(f.getFood(Long.parseLong(idarr[i])));
                     food = f.getFood(Long.parseLong(idarr[i]));
                     System.out.println("Food "+food);
                     ow.addFood(food);
                     o.updateOwner(ow);
                     System.out.println("food set"+ow.getFoods());
                     food.addOwner(ow);
                     f.updateFood(food);
                     System.out.println("Owner Set"+food.getOwners());
                       
                }
                   
                    String msg ="Food has been added successfully";
                        //mv = new ModelAndView("EventOwnerHomePage");
                    mv = new ModelAndView("success","message", msg);
                    
                    
                        //mv = new ModelAndView("EventOwnerHomePage");
                //}else{
                   //  mv = new ModelAndView("error", "message", "Not able to add new Food");
               // }
                //mv = new ModelAndView("");
//                String 
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerChange.htm")){
                String opt = request.getParameter("optionViewPendingOrder");
                if(opt.equalsIgnoreCase("viewCustChange")){
                    List<EventOrder> listcustreq = new ArrayList();
                     venList = v.getVenue((Owner)sess.getAttribute("user"));
                    for(Venue ve: venList){
                        listcustreq.addAll(e.getEventOrdersByStatus("Customer requested change",ve));
                    }
                    
//                    = e.getEventOrdersByStatus("Customer requested change",(Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventOwnerViewChangeReq","listcustreq",listcustreq);
                }else if(opt.equalsIgnoreCase("viewWorkerChange")){
                     List<EventOrder> listworkreq = new ArrayList();
                     venList = v.getVenue((Owner)sess.getAttribute("user"));
                    for(Venue ve: venList){
                        listworkreq.addAll(e.getEventOrdersByStatus("Worker requested change",ve));
                    }
                    mv = new ModelAndView("EventOwnerViewWorkChange","listworkreq",listworkreq);
                }else if(opt.equalsIgnoreCase("viewCompensationRequest")){
                    //compensation 
                }
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerCustReqUp.htm")){
                long rid = Long.parseLong(request.getParameter("id"));
                EventOrder ev1 = e.getEventOrderById(rid);
                if(!ev1.getStatus().equalsIgnoreCase("Completed") && !ev1.getStatus().equalsIgnoreCase("Closed")){
                     ev1.setStatus("Editable");
                     e.updateEventOrder(ev1);
                  List<EventOrder> listcustreq = new ArrayList();
                  venList = v.getVenue((Owner)sess.getAttribute("user"));
                                       
                  for(Venue ve: venList){
                        listcustreq.addAll(e.getEventOrdersByStatus("Customer requested change",ve));
                    }
                    
//                    = e.getEventOrdersByStatus("Customer requested change",(Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventOwnerViewChangeReq","listcustreq",listcustreq);
                }
                else{
                    sess.setAttribute("m", "Order already completed");
                    List<EventOrder> listcustreq = new ArrayList();
                  venList = v.getVenue((Owner)sess.getAttribute("user"));

                  for(Venue ve: venList){
                        listcustreq.addAll(e.getEventOrdersByStatus("Customer requested change",ve));
                
                  }
                    
//                    = e.getEventOrdersByStatus("Customer requested change",(Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventOwnerViewChangeReq","listcustreq",listcustreq);
                }
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerCustReqDec.htm")){
                long rid = Long.parseLong(request.getParameter("id"));
                EventOrder ev1 = e.getEventOrderById(rid);
                if(!ev1.getStatus().equalsIgnoreCase("Completed") && !ev1.getStatus().equalsIgnoreCase("Closed")){
                    ev1.setStatus("NotEditable");
                    e.updateEventOrder(ev1);
                    List<EventOrder> listcustreq = new ArrayList();
                    venList = v.getVenue((Owner)sess.getAttribute("user"));

                    for(Venue ve: venList){
                        listcustreq.addAll(e.getEventOrdersByStatus("Customer requested change",ve));
                    }
                    
//                    = e.getEventOrdersByStatus("Customer requested change",(Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventOwnerViewChangeReq","listcustreq",listcustreq);
                }else{
                    sess.setAttribute("m", "Order already completed");
                    List<EventOrder> listcustreq = new ArrayList();
                    venList = v.getVenue((Owner)sess.getAttribute("user"));

                  for(Venue ve: venList){
                        listcustreq.addAll(e.getEventOrdersByStatus("Customer requested change",ve));
                    }
                    
//                    = e.getEventOrdersByStatus("Customer requested change",(Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventOwnerViewChangeReq","listcustreq",listcustreq);
                }
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerWorkReqUp.htm")){
                long rid = Long.parseLong(request.getParameter("id"));
                EventOrder ev1 = e.getEventOrderById(rid);
                ev1.setStatus("Approved");
                e.updateEventOrder(ev1);
                List<EventOrder> listcustreq = new ArrayList();
                    venList = v.getVenue((Owner)sess.getAttribute("user"));

                    for(Venue ve: venList){
                        listcustreq.addAll(e.getEventOrdersByStatus("Worker requested change",ve));
                    }
                    
//                    = e.getEventOrdersByStatus("Customer requested change",(Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventOwnerViewWorkChange","listcustreq",listcustreq);
//                mv = new ModelAndView("EventOwnerChangeReq");
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerWorkReqDec.htm")){
                long rid = Long.parseLong(request.getParameter("id"));
                EventOrder ev1 = e.getEventOrderById(rid);
                ev1.setStatus("Declined");
                List<EventOrder> listcustreq = new ArrayList();
                   venList = v.getVenue((Owner)sess.getAttribute("user"));

                    for(Venue ve: venList){
                        listcustreq.addAll(e.getEventOrdersByStatus("Worker requested change",ve));
                    }
                    
//                    = e.getEventOrdersByStatus("Customer requested change",(Owner)sess.getAttribute("user"));
                    mv = new ModelAndView("EventOwnerViewWorkChange","listcustreq",listcustreq);
//                mv = new ModelAndView("EventOwnerChangeReq");
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerBrowseOrder.htm")){
                String opt = request.getParameter("optionViewAllOrder");
                if(opt.equalsIgnoreCase("viewCompletedOrders")){
                    venList = v.getVenue((Owner)sess.getAttribute("user"));

                    for(Venue ve: venList){
                        listCompleted.addAll(e.getEventOrdersByStatus("Completed",ve));
                    }
                    for(Venue ve: venList){
                        listClosed.addAll(e.getEventOrdersByStatus("Closed",ve));
                    }
                    
                    boolean b = listCompleted.addAll(listClosed);
                    mv = new ModelAndView("EventOwnerViewCompleted","listcompleted",listCompleted);
                }else if(opt.equalsIgnoreCase("viewAllOrders")){
                    venList = v.getVenue((Owner)sess.getAttribute("user"));
                    for(Venue ve: venList){
                        listCompleted.addAll(e.getEventOrdersByStatus("Completed",ve));
                    }
                    for(Venue ve: venList){
                        listClosed.addAll(e.getEventOrdersByStatus("Closed",ve));
                    }
                    for(Venue ve: venList){
                        getAll.addAll(e.getEventOrdersVen(ve));
                    }
                    getAll.removeAll(listClosed);
                    getAll.removeAll(listCompleted);
                    mv = new ModelAndView("EventOwnerViewAll","listworkreq",getAll);           
            }
            }
            else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerOrderStart.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                EventOrder e2 = e.getEventOrderById(id);
                if(!e2.getStatus().equalsIgnoreCase("Completed") && !e2.getStatus().equalsIgnoreCase("Closed")){
                    e2.setStatus("In Progress");
                    e.updateEventOrder(e2);
                    String m = "Hi "+e2.getCustomer().getFirstname()+" ,Hurray !! Your Order has been started";
                    EventMailController.sendEmail("aishwaryasawant697@gmail.com", "evento2494@gmail.com", m, "Order Started");
                     venList = v.getVenue((Owner)sess.getAttribute("user")); 
                    for(Venue ve: venList){
                        listCompleted.addAll(e.getEventOrdersByStatus("Completed",ve));
                    }
                    for(Venue ve: venList){
                        listClosed.addAll(e.getEventOrdersByStatus("Closed",ve));
                    }
                    for(Venue ve: venList){
                        getAll.addAll(e.getEventOrdersVen(ve));
                    }
                    getAll.removeAll(listClosed);
                    getAll.removeAll(listCompleted);
                    mv = new ModelAndView("EventOwnerViewAll","listworkreq",getAll); 
                }else{
                    sess.setAttribute("comp", "Order is already Closed or Completed");
                     venList = v.getVenue((Owner)sess.getAttribute("user"));
                     for(Venue ve: venList){
                        listCompleted.addAll(e.getEventOrdersByStatus("Completed",ve));
                    }
                    for(Venue ve: venList){
                        listClosed.addAll(e.getEventOrdersByStatus("Closed",ve));
                    }
                    for(Venue ve: venList){
                        getAll.addAll(e.getEventOrdersVen(ve));
                    }
                    getAll.removeAll(listClosed);
                    getAll.removeAll(listCompleted);
                    mv = new ModelAndView("EventOwnerViewAll","listworkreq",getAll);
                }
            
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOwnerOrderComplete.htm")){
                long id = Long.parseLong(request.getParameter("id"));
                EventOrder e2 = e.getEventOrderById(id);
                if(e2.getStatus().equalsIgnoreCase("In Progress")){
                    e2.setStatus("Completed");
                    e.updateEventOrder(e2);
                    venList = v.getVenue((Owner)sess.getAttribute("user"));
                    for(Venue ve: venList){
                        listCompleted.addAll(e.getEventOrdersByStatus("Completed",ve));
                    }
                    for(Venue ve: venList){
                        listClosed.addAll(e.getEventOrdersByStatus("Closed",ve));
                    }
                    for(Venue ve: venList){
                        getAll.addAll(e.getEventOrdersVen(ve));
                    }
                    String m = "Hi "+e2.getCustomer().getFirstname()+" ,Hurray !! Your Order has been completed";
                    EventMailController.sendEmail("aishwaryasawant697@gmail.com", "evento2494@gmail.com", m, "Order Completed");

                    getAll.removeAll(listClosed);
                    getAll.removeAll(listCompleted);
                    mv = new ModelAndView("EventOwnerViewAll","listworkreq",getAll);
                    //                    mv = new ModelAndView("EventOwnerViewAll");
                     
                }else{
                    String comp ="Order should be made in progress first to complete it";
                    sess.setAttribute("comp", comp);
                     venList = v.getVenue((Owner)sess.getAttribute("user"));
                      for(Venue ve: venList){
                        listCompleted.addAll(e.getEventOrdersByStatus("Completed",ve));
                    }
                    for(Venue ve: venList){
                        listClosed.addAll(e.getEventOrdersByStatus("Closed",ve));
                    }
                    for(Venue ve: venList){
                        getAll.addAll(e.getEventOrdersVen(ve));
                    }
                    //sess.setAttribute("comp", msg);
                    getAll.removeAll(listClosed);
                    getAll.removeAll(listCompleted);
                    mv = new ModelAndView("EventOwnerViewAll","listworkreq",getAll);
                }
                
                   // mv = new ModelAndView("EventOwnerViewAll");        
            
            }
        else{
                mv = new ModelAndView("EventOrganisationLogin");
            } 
        return mv;
        }                 
    }
