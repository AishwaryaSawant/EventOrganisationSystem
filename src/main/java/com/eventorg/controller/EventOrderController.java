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
public class EventOrderController extends AbstractController{
    public EventOrderController() {
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
        
        Owner owner =null;
        Customer customer = null;
        Worker worker = null;
        EventOrder eventorder = null;
        
        Set<Worker> workersorder = new HashSet();
        Set<Food> foodsorder = new HashSet();
        
        Venue venue = null;

        double discount = 0;
        double calculate = 0;
        if(request.getRequestURI().equals("/EventOrganisationSystem/EventCustomerOptionSelected.htm")){
                String custopt = request.getParameter("customeroptions");
                if(custopt.equalsIgnoreCase("placeEventOrder")){
                    List<Venue> venues = v.getAllVenues();
                    System.out.println("ven "+venues);
                    mv = new ModelAndView("EventOrderStart","venlist",venues);
                }else if(custopt.equalsIgnoreCase("viewEventOrders")){
                    List<EventOrder> eventorderlist = e.getEventOrdersById(((Customer)sess.getAttribute("usercust")).getCid());
                    mv = new ModelAndView("EventOrderView","orderlist",eventorderlist);
                }
            }
                else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOrderVenueSelected.htm")){
                System.out.println(request.getParameter("id"));
                 Venue ven = v.getVenue(Long.parseLong(request.getParameter("id")));
                 calculate = ven.getPrice();
                 sess.setAttribute("calc", calculate);
                 sess.setAttribute("ordervenue", ven);
//                List<Venue> venues = v.getVenuesByLocation(l.getLocation(Long.parseLong(request.getParameter("location"))));
                List<Food> foods = f.getFoods();
//                sess.setAttribute("venlist", venues);
//                sess.setAttribute("foolist", foods);
                mv = new ModelAndView("EventOrderFoodSelect","listFood",foods);
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOrderFoodSelected.htm")){
                 //Venue ven = v.getVenue(Long.parseLong(request.getParameter("id")));
                String[] idarr = request.getParameterValues("foodname");
                for(int i=0;i<idarr.length;i++){
                    
                    foodsorder.add(f.getFood(Long.parseLong(idarr[i])));
                    calculate = (f.getFood(Long.parseLong(idarr[i])).getPrice())+Double.parseDouble(sess.getAttribute("calc").toString());
                    sess.setAttribute("calc", calculate);
                    
                }
                System.out.println("foodsorder "+foodsorder);
                sess.setAttribute("orderfood", foodsorder);
                 List<Worker> workers = w.getAllWorkers();
//                List<Venue> venues = v.getVenuesByLocation(l.getLocation(Long.parseLong(request.getParameter("location"))));
//                sess.setAttribute("venlist", venues);
//                sess.setAttribute("foolist", foods);
                mv = new ModelAndView("EventOrderWorkerSelect","listworkers",workers);
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventOrderWorkerSelected.htm")){
                 //Venue ven = v.getVenue(Long.parseLong(request.getParameter("id")));
                 String[] idarr = request.getParameterValues("workername");
                 System.out.println("idarr: "+idarr[0]);
                 calculate = Double.parseDouble(sess.getAttribute("calc").toString());
                for(int i=0;i<idarr.length;i++){
                    System.out.println(w.getWorker(Long.parseLong(idarr[i])).getFirstname());
                    calculate += 100;
                    workersorder.add(w.getWorker(Long.parseLong(idarr[i])));
                }
                sess.setAttribute("calc", calculate);
                sess.setAttribute("orderworker", workersorder);
                 //List<Worker> worker = w.getAllWorkers();
//                List<Venue> venues = v.getVenuesByLocation(l.getLocation(Long.parseLong(request.getParameter("location"))));
//                sess.setAttribute("venlist", venues);
//                sess.setAttribute("foolist", foods);
                String msg = "";
                mv = new ModelAndView("EventDateSelect","message",msg);
            }else if(request.getRequestURI().equals("/EventOrganisationSystem/EventDateSelected.htm")){
                
                
                 //Venue ven = v.getVenue(Long.parseLong(request.getParameter("id")));
                SimpleDateFormat formatter1=new SimpleDateFormat("MM/dd/yyyy");
                Date date1=formatter1.parse(request.getParameter("eventdate")); 
                java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                System.out.println("sqldate "+sqlDate);
                
                SimpleDateFormat sdf3 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
                Set<Date> vendates = ((Venue)sess.getAttribute("ordervenue")).getVenueassignment();
                System.out.println("testtt ; "+((Venue)sess.getAttribute("ordervenue")).getVenueassignment());
                System.out.println("ordervenue "+(Venue)sess.getAttribute("ordervenue"));
                System.out.println("vendate "+vendates);
                
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                for(Date d : vendates){
                    String strDate = sdf3.format(d);  
                    //Date d3 = sdf3.parse(strDate);
                    System.out.println("d3 "+strDate);
                }
                
//                String dateStr = sqlDate.toString();
//                //DateFormat formatter3 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
//                Date date3 = (Date)formatter1.parse(dateStr);
//                //System.out.println(date3);        
//
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(date3);
//                String formatedDate = cal.get(Calendar.MONTH) + "/" + (cal.get(Calendar.DATE) + 1) + "/" + cal.get(Calendar.YEAR);
//                System.out.println("formatedDate : " +formatedDate); 
//                
//                
                 //venue = (Venue)sess.getAttribute("ordervenue");
                 String eventname = request.getParameter("eventname");
//                 Set<Date> assignDates = venue.getVenueassignment();
//                 Date date2 ;
//                 java.sql.Date sqlDate2;
//                 Set<java.sql.Date> sqlDate3 = new HashSet();
//                 for(Date d: assignDates){
//                      date2 =formatter1.parse(request.getParameter("eventdate")); 
//                      sqlDate2 = new java.sql.Date(date1.getTime());
//                      System.out.println("sqldate2"+sqlDate2);
//                      sqlDate3.add(sqlDate2);
//                     System.out.println("Assign date: "+d);
//                 }
                 
                 if(vendates.contains(sqlDate)){
                     String msg="Please select an available date";
                     mv = new ModelAndView("EventDateSelect","message",msg);
                 }else{
                     Venue v1 = ((Venue)sess.getAttribute("ordervenue"));
                     v1.addVenueAssignment(sqlDate);
                     sess.setAttribute("eventdate", sqlDate);
                    //venue.addVenueAssignment(date1);
                    v.updateVenue(v1);
                    sess.setAttribute("ordervenue", v1);
                    System.out.println("Venue assignment  "+((Venue)sess.getAttribute("ordervenue")).getVenueassignment());
                    sess.setAttribute("orderdate", sqlDate);
                    
                    
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
                    Date date = new Date(); 
                    java.sql.Date sqlDate1 = new java.sql.Date(date.getTime());
//                    
//                    Set<Date> assignDates1 = new HashSet(); 
//                    for(Worker worker1: (Set<Worker>)sess.getAttribute("orderworker")){
//                        assignDates1 = worker1.getWorkerassignment();
//                        if(assignDates1.contains(sqlDate)){
//                            String msg="Please select worker set again except "+worker1.getFirstname()+" because he is unavilable";
//                            mv = new ModelAndView("EventWorkerSelect","message",msg);
//                        }else{
//                            worker1.addWorkerAssignment(sqlDate);
//                        }
//                    }
                    if(((Venue)sess.getAttribute("ordervenue")).isIsnegotiable()==true){
                        discount = 20;
                    }
                    
                    calculate =Double.parseDouble(sess.getAttribute("calc").toString()) - discount;
                    eventorder = e.addEventorder(eventname,sqlDate, discount, calculate, sqlDate1, "placed", (Customer)sess.getAttribute("usercust"), (Venue)sess.getAttribute("ordervenue"), (Set<Worker>)sess.getAttribute("orderworker"), (Set<Food>)sess.getAttribute("orderfood"));
                    sess.setAttribute("eventorder", eventorder);
                    for(Food fo : (Set<Food>)sess.getAttribute("orderfood")){
                        System.out.println("foo"+fo);
                        System.out.println("fo "+fo.getEventorders());
                        fo.addEventOrder(eventorder);
                        int res = f.updateFood(fo);
                        System.out.println("ef "+eventorder.getFoods());
                        eventorder.addFood(fo);
                        int i = e.updateEventOrder(eventorder);
                    }
                    
                    
                    for(Worker wo : (Set<Worker>)sess.getAttribute("orderworker")){
                        System.out.println("fo "+wo.getEventorders());
                        wo.addEventorder(eventorder);
                        int res1= w.updateWorker(wo);
                        System.out.println("ew "+wo.getEventorders());
                        eventorder.addWorker(wo);
                        int j = e.updateEventOrder(eventorder);
                    }
                    
                    
                    
                                        //System.out.println(formatter.format(date));  
                 //List<Worker> worker = w.getAllWorkers();
//                List<Venue> venues = v.getVenuesByLocation(l.getLocation(Long.parseLong(request.getParameter("location"))));
//                sess.setAttribute("venlist", venues);
//                sess.setAttribute("foolist", foods);
                if(eventorder!=null){
                     String msg ="Event Order has been placed successfully";
                        //mv = new ModelAndView("EventOwnerHomePage"); venueUpdate
                     mv = new ModelAndView("success","message", msg);
                }else{
                     mv = new ModelAndView("error", "message", "Not able to place event order");
                }
//                    mv = new ModelAndView("EventOrderPlacement");
                 }
            }
        
        else{
                mv = new ModelAndView("EventOrganisationLogin");
            } 
        return mv;
        }                 
    }

