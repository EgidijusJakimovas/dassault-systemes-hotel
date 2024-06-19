<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
        }
        h1, h2, h3 {
            color: #333;
        }
        code {
            background: #f4f4f4;
            padding: 5px;
            border-radius: 5px;
        }
        pre {
            background: #f4f4f4;
            padding: 10px;
            border-radius: 5px;
            overflow-x: auto;
        }
    </style>
</head>
<body>
    <h1>Hotel Management System</h1>
    <p>This project is a simple hotel management system implemented in Java. The system allows for the registration, check-out, and management of guests in a hotel with both standard and business class rooms.</p>

    <h2>Features</h2>
    <ul>
        <li>Register guests</li>
        <li>Check-out guests</li>
        <li>View room availability</li>
        <li>View room occupancy history</li>
        <li>Generate room occupancy reports</li>
    </ul>

    <h2>Getting Started</h2>
    <p>To get started with this project, you will need to have Java installed on your system. Clone the repository and compile the code using a Java compiler.</p>
    <pre><code>git clone https://github.com/yourusername/hotel-management-system.git
cd hotel-management-system
javac Main.java
java Main</code></pre>

    <h2>Classes Overview</h2>
    <h3>BusinessRoom</h3>
    <p>Represents a business class room in the hotel. Extends the <code>Room</code> class.</p>

    <h3>Guest</h3>
    <p>Represents a guest in the hotel with a name and surname.</p>

    <h3>HotelManagement</h3>
    <p>Manages the hotel's operations including registering guests, checking out guests, and generating reports.</p>

    <h3>Main</h3>
    <p>Contains the main method to run the application. Provides a simple text-based menu for interacting with the system.</p>

    <h3>Room</h3>
    <p>Represents a room in the hotel with a room number, price, guest information, and occupancy history.</p>

    <h3>RoomOccupancyHistory</h3>
    <p>Represents the occupancy history of a room including the guest's name, check-in date, and check-out date.</p>

    <h2>Usage</h2>
    <p>After running the application, you can interact with the system through the provided menu:</p>
    <ol>
        <li>Register Guest</li>
        <li>Check-out Guest</li>
        <li>Review Standard and Business Class Room Availability</li>
        <li>Room Occupancy History and Status</li>
        <li>Room Occupancy Report</li>
        <li>Exit</li>
    </ol>

    <p>Select the corresponding number to perform an action. For example, to register a guest, enter <code>1</code> and follow the prompts.</p>

    <h2>Contributing</h2>
    <p>Contributions are welcome! Please fork the repository and submit a pull request.</p>

    <h2>License</h2>
    <p>This project is licensed under the MIT License.</p>
</body>
</html>
