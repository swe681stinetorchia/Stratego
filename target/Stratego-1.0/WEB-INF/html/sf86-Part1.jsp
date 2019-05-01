<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <meta name="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)">
   <meta name="dcterms.created" content="Tue, 11 Oct 2016 15:07:22 GMT">
   <meta name="description" content="">
   <meta name="keywords" content="">

<title>eApp Form</title>


<link rel="stylesheet" type="text/css" href="${initParam.siteURL}/styles.css">
<link rel="stylesheet" type="text/css" href="styles.css">

<style type="text/css">
</style>

</head>

<body>
	<header>
		<h1>eApp
			<img src="${initParam.siteURL}/NBIB-logo.png" width="79" height="79" style="vertical-align:middle; margin-right:10px; float:right;">
		</h1>
		<hr style="margin: auto; height: 1px" />
	</header>

	<section>
	    <p style="font-weight: bold; text-align: center; margin-top: 30px; margin-bottom: 0px">
			QUESTIONNAIRE FOR NATIONAL SECURITY POSITIONS</p>
		<p style="font-size: 10pt; text-align: center; margin-top: 4px; margin-bottom: 30px">
			Standard Form 86</p>
		<p>GENERAL INSTRUCTIONS:</p>
		<ul>
			<li>Answer each question as completely as possible.</li>
			<li>If the question does not apply to you, enter "NA"</li>
			<li>If you need additional space to fully answer a question, use the <i>Additional
				Comments</i> section at the bottom of the page.
			</li>
			<li>You do not need to complete the form all at once. You may use the <i>Save</i>
				button to save your work at any time and log out. You can then log back in at a later
				time to continue.
			</li>
			<li>You can go back to previous sections at any time to modify your answers.</li>
			<li>Once you have electronically signed your questionnaire and submitted it, you will
				no longer be able to make changes.</li>
		</ul>
	</section>

	<section>
		<p class="formPart" style="margin-top: 20px">Part 1</p>
	</section>

	<form method="post" id="part1Form" action="${initParam.siteURL}/servlets">
		<table class="questionText" cellpadding="10">
			<tr>
				<td class="questionNumber">1</td>
				<td style="padding-left: 6px;"><b>FULL NAME</b>
					<ul>
						<li>If you have only initials in your name, use them and state "<i>(IO)</i>"</li>
						<li>If you have no middle name, enter "<i>NMN</i>"</li>
						<li>If you have a name suffix such as "Jr.", "Sr.", "II", etc, enter it in
							the box after your middle name.</li>
					</ul>

					<table cellspacing="6px">
               <tr style="text-align: right;">
							<td>
								<label>Last Name: <input type="text" name="lastName" value=""></label>
							</td>
							<td>
								<label>First Name: <input type="text" name="firstName" value=""></label>
							</td>
						</tr>
						<tr>
							<td><label>Middle Name: <input type="text" name="middleName" value="">
								</label>
							</td>
							<td>
								<label>Suffix (Jr., II, etc.): <input type="text" name="suffix" value="">
								</label>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="questionNumber">2</td>
				<td>
					<b>DATE OF BIRTH</b>
					<table class="questionText" cellspacing="10px">
						<tr>
							<td>
								<label>Month: <input type="number" min="1" max="12"
										  name="monthOfBirth" value="" style="width: 35px">
								</label>
							</td>
							<td>
							  <label>Day: <input type="number" min="1" max="31"
									name="dayOfBirth" value="" style="width: 35px">
							  </label>
							</td>
							<td>
								<label>Year: <input type="number" min="1900"
									name="yearOfBirth" value="" style="width: 50px">
								</label>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="questionNumber">3</td>
				<td><b>PLACE OF BIRTH</b>
					<table cellspacing="10px">
						<tr>
							<td>
								<label>City: <input type="text" name="cityOfBirth" value=""
									style="width: 100px">
								</label>
							</td>
							<td><label>County: <input type="text" name="countyOfBirth"
									value="" style="width: 100px">
								 </label>
							</td>
							<td>
								<label>State:
									<select>
										<option></option>
										<option>AL</option>
										<option>AK</option>
										<option>AZ</option>
										<option>AR</option>
										<option>CA</option>
										<option>CO</option>
										<option>CT</option>
										<option>DC</option>
										<option>DE</option>
										<option>FL</option>
										<option>GA</option>
										<option>HI</option>
										<option>ID</option>
										<option>IL</option>
										<option>IN</option>
										<option>IA</option>
										<option>KS</option>
										<option>KY</option>
										<option>LA</option>
										<option>ME</option>
										<option>MD</option>
										<option>MA</option>
										<option>MI</option>
										<option>MN</option>
										<option>MS</option>
										<option>MO</option>
										<option>MT</option>
										<option>NE</option>
										<option>NV</option>
										<option>NH</option>
										<option>NJ</option>
										<option>NM</option>
										<option>NY</option>
										<option>NC</option>
										<option>ND</option>
										<option>OH</option>
										<option>OK</option>
										<option>OR</option>
										<option>PA</option>
										<option>RI</option>
										<option>SC</option>
										<option>SD</option>
										<option>TN</option>
										<option>TX</option>
										<option>UT</option>
										<option>VT</option>
										<option>VA</option>
										<option>WA</option>
										<option>WV</option>
										<option>WI</option>
										<option>WY</option>
									</select>
								</label>
							</td>
							<td>
								<label>Country (if not U.S.): <input type="text"
									name="countryOfBirth" value="" style="width: 100px">
								</label>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="questionNumber">4</td>
				<td><b>SOCIAL SECURITY NUMBER</b>
					<table cellspacing="10px">
						<tr>
							<td><input type="text" name="ssn" value="" style="width: 120px"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="questionNumber">5</td>
				<td><b>OTHER NAMES USED</b>
					<p>
						Give other names you have used and the period of time you used them (for example:
						your maiden name, name[s] by a former marriage, former name[s], alias[es], or
						nickname[s]. If the other name is your maiden name, put "<b>nee</b>" in front of
						it.
					</p>
					<table cellspacing="10px">
						<tr>
							<td>
								<label>#1 Name: <input type="text" name="otherName1" value=""
									style="width: 240px">
								</label>
							</td>
							<td>
								<label>From (mo/yr): <input type="text" name="otherName1From"
									value="" style="width: 60px">
								</label>
							</td>
							<td>
								<label>To (mo/yr): <input type="text" name="otherName1To"
									value="" style="width: 60px">
								</label>
							</td>
						</tr>
						<tr>
							<td>
								<label>#2 Name: <input type="text" name="otherName2" value=""
									style="width: 240px">
								</label>
							</td>
							<td>
								<label>From (mo/yr): <input type="text" name="otherName2From"
									value="" style="width: 60px">
								</label>
							</td>
							<td>
								<label>To (mo/yr): <input type="text" name="otherName2To"
									value="" style="width: 60px">
								</label>
							</td>
						</tr>
						<tr>
							<td>
								<label>#3 Name: <input type="text" name="otherName3" value=""
									style="width: 240px">
								</label>
							</td>
							<td>
								<label>From (mo/yr): <input type="text" name="otherName3From"
									value="" style="width: 60px">
								</label>
							</td>
							<td>
								<label>To (mo/yr): <input type="text" name="otherName3To"
									value="" style="width: 60px">
								</label>
							</td>
						</tr>
						<tr>
							<td>
								<label>#4 Name: <input type="text" name="otherName4" value=""
									style="width: 240px">
								</label>
							</td>
							<td>
								<label>From (mo/yr): <input type="text" name="otherName4From"
									value="" style="width: 60px">
								</label>
							</td>
							<td>
								<label>To (mo/yr): <input type="text" name="otherName4To"
									value="" style="width: 60px">
								</label>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="questionNumber">6</td>
				<td><b>OTHER IDENTIFYING INFORMATION</b>
					<p>
						<label style="padding-left:10px">Height (feet and inches): <input
							type="text" name="height" value="" style="width: 80px">
						</label>
						<label style="padding-left:10px">Weight (pounds): <input type="text"
							name="weight" value="" style="width: 40px">
						</label>
					</p>
					<p>
						<label style="padding-left:10px">Hair Color: <input type="text"
							name="hairColor" value="" style="width: 80px">
						</label>
						<label style="padding-left:10px">Eye Color: <input type="text"
							name="eyeColor" value="" style="width: 80px">
						</label>
					</p>
					<p>
						<label style="padding-left:10px">Sex: <input type="radio" name="gender"
							value="male">Male
						</label> <input type="radio" name="gender" value="female">Female
					</p>
				</td>
			</tr>
			<tr>
				<td class="questionNumber">7</td>
				<td><b>TELEPHONE NUMBERS</b>
					<p>Include Area Codes and, where applicable, extensions.</p>
					<table cellspacing="10px">
						<tr>
							<td style="text-align: right">Work:</td>
							<td>
								<input type="text" name="workPhone" value="" style="width: 160px">
							</td>
							<td>
								<input type="radio" name="workCallTime" value="day">Day
								<input type="radio" name="workCallTime" value="night">Night
								<input type="radio" name="workCallTime" value="either">Either
							</td>
						</tr>
						<tr>
							<td style="text-align: right">Home:</td>
							<td>
								<input type="text" name="homePhone" value="" style="width: 160px">
							</td>
							<td>
								<input type="radio" name="homeCallTime" value="day">Day
								<input type="radio" name="homeCall Time" value="night">Night
								<input type="radio" name="homeCallTime" value="either">Either
							</td>
						</tr>
						<tr>
							<td style="text-align: right">Cell:</td>
							<td>
								<input type="text" name="cellPhone" value="" style="width: 160px">
							</td>
							<td>
								<input type="radio" name="cellCallTime" value="day">Day
								<input type="radio" name="cellCallTime" value="night">Night
								<input type="radio" name="cellCallTime" value="either">Either
							</td>
						</tr>
					</table>
				</td>
			<tr>
				<td class="questionNumber">8</td>
				<td><b>CITIZENSHIP</b>
					<p>Select the option below that reflects your current citizenship status, and
						follow its instructions.</p>
					<table cellspacing="4px">
						<tr>
							<td>
								<input type="radio" name="citizen" value="byBirth"> I am a U.S. citizen or
								national by birth in the U.S. or U.S. territory/possession.
								<span style="font-size: 16pt">&nbsp;&nbsp; &#x2192;</span> Answer questions
								A and C.
							</td>
						</tr>
						<tr>
							<td>
								<input type="radio" name="citizen" value="naturalized"> I am a U.S.
								citizen, but I was NOT born in the U.S. <span style="font-size: 16pt">
								&nbsp;&nbsp;&#x2192;</span> Answer questions A, B, and C.
							</td>
						</tr>
						<tr>
							<td>
								<input type="radio" name="citizen" value="nonCitizen"> I am not a U.S.
									citizen. <span style="font-size: 16pt">&nbsp;&nbsp;&#x2192;</span>
									Answer questions A and D.
							</td>
						</tr>
					</table>

					<hr />
					<table style="margin-left: 20px; margin-top: 10px">
						<tr>
							<td>
								<p style="font-size: 16pt; margin: 0px;">A.</p>
							</td>
							<td><label style="margin-left: 10px">Your mother's maiden name:
								 <input type="text"/></label>
							</td>
						</tr>
					</table>

					<hr />
					<table style="margin-left: 20px; margin-top: 10px">
						<tr>
							<td style="vertical-align: top;">
								<p style="font-size: 16pt; margin: 0px;">B.</p>
							</td>
							<td style="padding-left: 10px;">
								<p style="margin-top: 0px">UNITED STATES CITIZENSHIP</p>
								<p>If you are a U.S. Citizen but not born in the U.S., provide
									information about one or more of the following proofs of your
									citizenship.</p>

								<table class="citizenshipTable">
									<tr>
										<td style="width: 174px;"><p style="font-size: 8pt; margin: 0px;">
												NATURALIZATION CERTIFICATE<br />(Where were you naturalized?)
											</p></td>
										<td><label>Court: <input type="text"
												name="naturalizationCourt" value="">
											</label> <label style="padding-left: 10px">City: <input
												type="text" name="naturalizationCity" value="">
											</label> <label style="padding-left: 10px">State: <input
												type="text" name="naturalizationState" value=""
												style="width: 40px">
											</label>
										</td>
									</tr>
									<tr>
										<td></td>
										<td style="margin-top: 6px">
											<label>Certificate Number: <input
												type="text" name="naturalizationCertNumber" value="">
											</label>
											<label style="padding-left: 10px">Month/Day/Year
												Issued: <input type="text" name="naturalizationDate" value=""
												style="width: 80px">
											</label>
										</td>
									</tr>
								</table>

								<table class="citizenshipTable">
									<tr>
										<td style="width: 174px;">
											<p style="font-size: 8pt; margin: 0px;">
												CITIZENSHIP CERTIFICATE<br />(Where was the certificate issued?)
											</p>
										</td>
										<td>
											<label>City: <input type="text" name="citizenshipCity" value="">
											</label>
											<label style="padding-left: 10px">State:
												<input type="text" name="citizenshipState" value="" style="width: 40px">
											</label>
										</td>
									</tr>
									<tr>
										<td></td>
										<td style="margin-top: 6px">
											<label>Certificate Number:
												<input type="text" name="citizenshipCertNumber" value="">
											</label>
											<label style="padding-left: 10px">Month/Day/Year Issued:
												<input type="text" name="citizenshipDate" value=""
													style="width: 80px">
											</label>
										</td>
									</tr>
								</table>

								<table class="citizenshipTable">
									<tr>
										<td style="width: 174px;">
											<p style="font-size: 8pt; margin: 0px;">
												STATE DEPT FORM 240<br />Report of Birth Abroad<br />of a
												Citizen of the United States
											</p>
										</td>
										<td>
											<label>Month/Day/Year form was prepared: <input
												type="text" name="birthAbroadDate" value="" style="width: 80px">
											</label>
										</td>
									</tr>
									<tr>
										<td></td>
										<td>
											<label>Explanation (if needed): </label><br/>
												<textarea form="part1Form" name="birthAbroadExplanation"
													rows="4" cols="60">
												</textarea>
										</td>
									</tr>
								</table>

								<table class="citizenshipTable">
									<tr>
										<td style="width: 174px;">
											<p style="font-size: 8pt; margin: 0px;">
												U.S. PASSPORT<br/>(Current or previous passport)
											</p>
										</td>
										<td>
											<label>Passport Number:
												<input type="text" name="passportNumber" value="">
											</label>
											<label style="padding-left: 10px">Month/Day/Year Issued:
												<input type="text" name="passportDate" value=""
													style="width: 80px">
										</label></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

					<hr />
					<table style="margin-left: 20px; margin-top: 10px">
						<tr>
							<td style="vertical-align: top;">
								<p style="font-size: 16pt; margin: 0px;">C.</p>
							</td>
							<td style="padding-left: 10px;">
								<p style="margin-top: 0px">DUAL CITIZENSHIP</p>
								<label>If you are (or were) a dual citizen of the United States and
									another country, provide the name of that country:
									<input type="text" name="dualCitizenship" value="" >
								</label>
							</td>
						</tr>
					</table>

					<hr />
					<table style="margin-left: 20px; margin-top: 10px">
						<tr>
				        <td style="vertical-align: top;">
                            <p style="font-size: 16pt; margin: 0px;">D.</p>
                        </td>
                            <td style="padding-left: 10px;">
								<p style="margin-top: 0px">ALIEN</p>
								<p>If you are an alien, provide the following information:</p>
								<p>
									<label style="padding-left: 10px">Place where you entered the
										United States. &nbsp;&nbsp;City: <input type="text" 
										name="cityOfEntry" value="">
									</label>
									<label style="padding-left: 10px">State: <input type="text"
										name="stateOfEntry" value="" style="width: 40px">
									</label>
								</p>
								<p>
									<label style="padding-left: 10px">Date you entered the U.S.
										&nbsp;&nbsp;Month: <input type="text" name="monthOfEntry" 
										value="" style="width: 40px">
									</label>
									<label style="padding-left: 10px">Day: <input type="text"
										name="dayOfEntry" value="" style="width: 40px">
									</label>
										<label style="padding-left: 10px">Year: <input type="text"
										name="yearOfEntry" value="" style="width: 60px">
									</label>
								</p>
								<p>
									<label style="padding-left: 10px">Alien Registration Number: 
									   <input type="text" name="alienRegNumber" value="">
									</label>
									<label style="padding-left: 10px">Country(ies) of Citizenship: 
									   <input type="text" name="alienCountriesofCitizenship" 
									   value="" style="width: 200px">
									</label>
								</p>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<p>
			Additional Comments:<br/>
			<textarea form="part1Form" name="additionalComments" style="width: 100%; height: 100px">
			</textarea>
		</p>

		<p style="text-align: center; margin-top: 20px">
			<input type="submit" name="savePart1" value="Save" style="margin-right: 10px" />
			<input type="submit" name="continuePart1" value="Save and Continue &#x2192;"
				style="margin-left: 10px"/>
		</p>
	</form>
	
</body>

</html>
