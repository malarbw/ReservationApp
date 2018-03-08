package com.gc.controller;

import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
import org.json.JSONArray;
import org.json.JSONObject;
=======
>>>>>>> 891f05afe6063ff765d7abeaa56d9eeedaf58843
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.dao.CustomerDaoImp;
import com.gc.dao.CustomersDao;
import com.gc.dao.DogsDaoImp;
import com.gc.dao.ReservationDoaImp;
import com.gc.model.Customers;
import com.gc.model.Dogs;
import com.gc.model.Reservation;

/**
 * 
 * @author: Abduljabbar Shaamala
 *
 */

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "index" })
	public ModelAndView homePage() {

<<<<<<< HEAD
		String message = "<br><div style='text-align:center;'>" + "<h3>Beekel Farms Kennel</h3>";
		return new ModelAndView("index", "message", message);
	}

	@RequestMapping("/confirmation")
	public ModelAndView sendEmail2() {

		MailjetRequest email;
		MailjetResponse response = null;

		// Note how we set the version to v3.1 using ClientOptions
		// MailjetClient client = new
		// MailjetClient(System.getenv("737eb42ade92225b46e471d3d091fa80"),
		// System.getenv("3ffa02400a98cb6aeaf190ede5f50b5e"), new
		// ClientOptions("v3.1"));
		MailjetClient client = new MailjetClient(System.getProperty("PublicKey"), System.getProperty("PrivateKey"),
				new ClientOptions("v3.1"));

		JSONObject message = new JSONObject();
		message.put(Emailv31.Message.FROM,
				new JSONObject().put(Emailv31.Message.EMAIL, "malarbw@umich.edu").put(Emailv31.Message.NAME,
						"Administrator"))
				.put(Emailv31.Message.SUBJECT, "RESERVATION CONFRIMATION")
				.put(Emailv31.Message.TEXTPART, "Dear customer, thanks for reserving with our kennel.")
				.put(Emailv31.Message.HTMLPART,
						"<h3>Dear passenger, welcome to Mailjet</h3><br/>May the delivery force be with you!")
				.put(Emailv31.Message.TO, new JSONArray()
						.put(new JSONObject().put(Emailv31.Message.EMAIL, "ashaamala@hawkmail.hfcc.edu")));

		email = new MailjetRequest(Emailv31.resource).property(Emailv31.MESSAGES, (new JSONArray()).put(message));

		try {
			response = client.post(email);
		} catch (MailjetException | MailjetSocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("confirmation", "response", response.getStatus());
	}

	/* @RequestMapping("/confirmation") */
	public ModelAndView sendEmail() throws MailjetException, MailjetSocketTimeoutException {
		MailjetClient client = new MailjetClient(System.getenv("737eb42ade92225b46e471d3d091fa80"),
				System.getenv("3ffa02400a98cb6aeaf190ede5f50b5e"));
		MailjetRequest email;
		JSONArray recipients;
		MailjetResponse response;

		System.out.print("hello");

		recipients = new JSONArray().put(new JSONObject().put(Contact.EMAIL, "malarbw@umich.edu"));

		System.out.println(recipients);

		email = new MailjetRequest(Email.resource).property(Email.FROMNAME, "Administrator")
				.property(Email.FROMEMAIL, "ashaamala@hawkmail.hfcc.edu").property(Email.SUBJECT, "Thank you!")
				.property(Email.TEXTPART, "Thank you for choosing to stay at our kennel.")
				.property(Email.RECIPIENTS, recipients).property(Email.MJCUSTOMID, "JAVA-Email");

		response = client.post(email);

		return new ModelAndView("confirmation", "response", response);

	}

	@RequestMapping("/pricing")

	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>" + "<h3>Beekel Farms Kennel</h3>";
=======
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>This is homepage.java</h3>";
		return new ModelAndView("index", "message", message);
	}

	@RequestMapping("/pricing")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>This is the pricing page.java</h3>";
>>>>>>> 891f05afe6063ff765d7abeaa56d9eeedaf58843
		return new ModelAndView("pricing", "message", message);
	}

	@RequestMapping("/customerProfile")
	public ModelAndView addCustomer() {

<<<<<<< HEAD
		String message = "<br><div style='text-align:center;'>" + "<h3>Beekel Farms Kennel</h3>";
=======
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>This is the page to add a customer.java</h3>";
>>>>>>> 891f05afe6063ff765d7abeaa56d9eeedaf58843
		return new ModelAndView("customerProfile", "message", message);
	}

	@RequestMapping("/reserve")
	public ModelAndView reservation() {

<<<<<<< HEAD
		String message = "<br><div style='text-align:center;'>" + "<h3>Beekel Farms Kennel</h3>";
		return new ModelAndView("reserve", "message", message);
	}

=======
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>This is the reserve page.java</h3>";
		return new ModelAndView("reserve", "message", message);
	}
	

	
	// Add dog 
		@RequestMapping(value="adddog")
		public ModelAndView adddog(@RequestParam("dogName")String dogName,@RequestParam("breed")String breed,@RequestParam("size")String size,
				@RequestParam("food")String food) {
			
				Dogs dog = new Dogs();
				dog.setDogName(dogName);
				dog.setBreed(breed);
				dog.setSize(size);
				dog.setFood(food);
							  				
			DogsDaoImp test = new DogsDaoImp();
			test.addDogs(dog);
			
			String msg = "Add customer successful";
			
			return new ModelAndView("index","MSG",msg);
		}
	

		@RequestMapping(value="addCustomer")
		public ModelAndView addCustomersandReservation(@RequestParam("fName")String fName,@RequestParam("lName")String lName,@RequestParam("street")String street,
				@RequestParam("city")String city,@RequestParam("state")String state,@RequestParam("zip")String zip,@RequestParam("email")String email,@RequestParam("homeTel")String homeTel,
				@RequestParam("emrgTel")String emrgTel,@RequestParam("vetName")String vetName,@RequestParam("vetTel")String vetTel,
				@RequestParam("dropOff")String dropOff,@RequestParam("pickUp")String pickUp) {
			
			
			Customers customer = new Customers();
		    customer.setfName(fName);
			customer.setlName(lName);
			customer.setStreet(street);
			customer.setCity(city);
			customer.setState(state);
			customer.setZip(zip);
			customer.setEmail(email);
			customer.setHomeTel(homeTel);
			customer.setEmrgTel(emrgTel);
			customer.setVetName(vetName);
			customer.setVetTel(vetTel);
			
			Reservation reserv = new Reservation();
				reserv.setDropOff(dropOff);
				reserv.setPickUp(pickUp);
				reserv.setCustomer(customer);
				
				CustomerDaoImp test = new CustomerDaoImp();
				test.addCustomers(customer);
			ReservationDoaImp test1 = new ReservationDoaImp();
			test1.addReservation(reserv);
			
				
				String msg = "Reservation successful";
				
				return new ModelAndView("index","MSG",msg);
				
		}		
		
	
	
>>>>>>> 891f05afe6063ff765d7abeaa56d9eeedaf58843
}
