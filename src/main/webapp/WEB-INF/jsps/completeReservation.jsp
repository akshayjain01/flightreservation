<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Reservation</title>
</head>
<body>
	<h2>Complete Reservation :</h2>
	Airline : ${flight.operatingAirlines}
	<br /> Departure City : ${flight.departureCity}
	<br /> Airline : ${flight.arrivalCity}
	<br />

	<form action="completeReservation" method="post"></form>
<pre>

<h2>Passenger Details : </h2>
First Name : <input type="text" name="firstName" />
Middle Name : <input type="text" name="middleName" />
Last Name : <input type="text" name="lastName" />
Email : <input type="email" name="email" />
Phone : <input type="text" name="phone">

<h2>Card Details : </h2>
Name on the card : <input type="text" name="nameOnTheCard" />
Card Number : <input type="text" name="cardNumber" />
Expire Date : <input type="text" name="expirationDate" />
CVV : <input type="password" name="securityCode" />
<input type="hidden" name="flightId" value="${flight.id}" />
<input type="submit" value="Confirm" />

</pre>
	</form>

</body>
</html>