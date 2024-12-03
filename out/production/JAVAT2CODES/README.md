<h1 style="font-size:30px">JAVA CODES WITH CONCEPTS</h1>
<h1>Lab-1 Based on Concept of Constructor, method Overloading</h1>
<div>
<h3>Bank Vaildation <a href="https://github.com/srinijalanda93/JAVA2T2448526/blob/main/Lab1p1.java">"Lab1p1.java"</a></h3>
<p>This program checks if a given credit card number (8 to 9 digits) is valid using a series of steps. It removes the last digit, reverses the rest, doubles odd-positioned digits, and sums them. The final result is compared with the original last digit to determine validity. A constructor reads input, and a switch case(optional) handles each validation step. If the result matches, it prints "Valid card"; otherwise, it prints "Invalid card."</p>
<img width="827" alt="image" src="https://github.com/user-attachments/assets/ee8b2531-9643-4c0c-bb45-3ccdde13b3d4">
</div>
<div>
  
  <h3>Alphabet War <a href="https://github.com/srinijalanda93/JAVA2T2448526/blob/main/Lab1p2.java">"Lab1p2.java"</a></h3>
  <p>Alphabet War is a fun letter-battle game built using Java. Two teams—left-side and right-side letters—compete based on predefined strengths. The game demonstrates constructor overloading (to set default or custom strengths) and method overloading (to handle single or dual-word battles). Depending on the scores, the game prints “Left side wins!”, “Right side wins!”, or “Let’s fight again!” Enjoy experimenting with different strengths and scenarios!</p>
  <img width="625" alt="image" src="https://github.com/user-attachments/assets/e66ff320-4b30-4e9f-aaee-56261126da13">
</div>

<h2>Lab-2</h2>
<p>  
</p>
<h1>Lab-2 Program 1</h1>
<img width="671" alt="image" src="https://github.com/user-attachments/assets/2dcb8005-35d0-4bee-b2c6-b18c7365b61d">
<h1>Lab-2 Program-2</h1>
<img width="485" alt="image" src="https://github.com/user-attachments/assets/3c857142-874a-4dbc-91bb-35140ed4974f">

<h1>LAB-3 PROGRAM</h1>
<h1>Employee Management System</h1>
<img width="581" alt="image" src="https://github.com/user-attachments/assets/fad742be-4933-4f2a-b639-b5d8fda5c2bf">


<p>The code defines an employee management system using Java, consisting of a base class <code>Employ</code> and three subclasses (<code>HourlyEmploy</code>, <code>SalariedEmploy</code>, and <code>ExecutiveEmploy</code>). It demonstrates concepts of inheritance, encapsulation, and method overriding.</p>

<h2>Key Components</h2>

<h3>Base Class - <code>Employ</code>:</h3>
<ul>
    <li><strong>Attributes:</strong> Contains static and instance variables to hold employee details (name, designation, ID).</li>
    <li><strong>Constructor:</strong> Initializes employee details.</li>
    <li><strong>Methods:</strong>
        <ul>
            <li><code>getDetails()</code>: Prints employee information.</li>
            <li><code>calculationBonus()</code>: A private method for bonus calculations (not used in the current implementation).</li>
        </ul>
    </li>
</ul>

<h3>Subclass - <code>HourlyEmploy</code>:</h3>
<ul>
    <li>Inherits from <code>Employ</code>.</li>
    <li><strong>Additional Attributes:</strong> Holds hourly rate and hours worked.</li>
    <li><strong>Constructor:</strong> Initializes the attributes using the superclass constructor.</li>
    <li><strong>Methods:</strong>
        <ul>
            <li><code>weeklySalary()</code>: Calculates and prints weekly salary based on hours worked.</li>
        </ul>
    </li>
</ul>

<h3>Subclass - <code>SalariedEmploy</code>:</h3>
<ul>
    <li>Inherits from <code>Employ</code>.</li>
    <li><strong>Additional Attribute:</strong> Holds monthly salary.</li>
    <li><strong>Constructor:</strong> Initializes monthly salary along with employee details.</li>
    <li><strong>Methods:</strong>
        <ul>
            <li><code>weeklySalary()</code>: Calculates and prints weekly salary based on the monthly salary.</li>
        </ul>
    </li>
</ul>

<h3>Subclass - <code>ExecutiveEmploy</code>:</h3>
<ul>
    <li>Inherits from <code>SalariedEmploy</code>.</li>
    <li><strong>Additional Attributes:</strong> Holds age, experience, and bonus percentage.</li>
    <li><strong>Constructor:</strong> Initializes executive details including the bonus percentage.</li>
    <li><strong>Methods:</strong>
        <ul>
            <li><code>bonusPercentage()</code>: Calculates and prints total payroll based on the monthly salary and bonus percentage.</li>
        </ul>
    </li>
</ul>

<h3>Main Class - <code>Lab3p1</code>:</h3>
<ul>
    <li>Contains the <code>main()</code> method to create instances of <code>HourlyEmploy</code>, <code>SalariedEmploy</code>, and <code>ExecutiveEmploy</code>.</li>
</ul>


<h1>LAB-4</h1>
<h2>ABSTARCT CONCEPT</h2>
<p>can't create the object for abstract class
    Partially completed --> because object can't be created
    can have abstract method+non-abstracting methods
    Abstract Method only have the method call/not the method definition</p>
<img width="364" alt="image" src="https://github.com/user-attachments/assets/3c95f415-f75a-481d-88d1-5b25b25a563a">

<h1>LAB-5</h1>
<h2>INTERFACE CONCEPT (FULLY ABSTARCTION)</h2>
<p>Interface Creation: The BankInterface declares the methods getBalance and getInterestRate which all banks must implement.

Implementing Classes:

Each bank class stores its balance as a private attribute (encapsulation).
The getBalance method returns the balance.
The getInterestRate method returns the fixed interest rate for that bank.
Object Creation: Objects of BankA, BankB, and BankC are instantiated with their respective deposit amounts. The constructors initialize the balance.

Calling Methods: The methods getBalance and getInterestRate are called on each bank object to retrieve and display the balance and interest rate.
</p>
<img width="296" alt="image" src="https://github.com/user-attachments/assets/d8c1c3fc-780c-4273-b6ee-e0b6f86f9246">


