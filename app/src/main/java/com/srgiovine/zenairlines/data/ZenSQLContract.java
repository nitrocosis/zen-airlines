package com.srgiovine.zenairlines.data;

import android.provider.BaseColumns;

/**
 * Contains table names and columns.
 */
public final class ZenSQLContract {

    private ZenSQLContract() {
    }

    public static abstract class Customer implements BaseColumns {
        public static final String TABLE_NAME = "CUSTOMER";
        public static final String CUSTOMER_ID = _ID;
        public static final String FIRST_NAME = "FirstName";
        public static final String LAST_NAME = "LastName";
        public static final String SSN = "SSN";
        public static final String PHONE_NUMBER = "PhoneNumber";
        public static final String EMAIL = "Email";
        public static final String ADDRESS = "Address";
        public static final String CITY = "City";
        public static final String STATE = "State";
        public static final String ZIP = "Zip";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                FIRST_NAME + " TEXT NOT NULL," +
                LAST_NAME + " TEXT NOT NULL," +
                SSN + " TEXT NOT NULL," +
                PHONE_NUMBER + " TEXT NOT NULL," +
                EMAIL + " TEXT NOT NULL," +
                ADDRESS + " TEXT NOT NULL," +
                CITY + " TEXT NOT NULL," +
                STATE + " TEXT NOT NULL," +
                ZIP + " TEXT NOT NULL," +
                " UNIQUE (" + SSN + ")," +
                " UNIQUE (" + EMAIL + ")" +
                " )";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String INITIAL_INSERT = "INSERT INTO " + TABLE_NAME +
                "(" + FIRST_NAME + ", " + LAST_NAME + ", " + SSN + ", " + PHONE_NUMBER + ", " + EMAIL +
                ", " + ADDRESS + ", " + CITY + ", " + STATE + ", " + ZIP + ")" +
                " VALUES " +
                "('Johnny', 'Jones', '693212123', '7010852227', 'johnny.jones@freespace.com', 'Heather Sees Way', 'Tulsa', 'OK', '74105')," +
                "('Albert', 'Stinnett', '321837283', '9145263727', 'albert.stinnett@freespace.com', 'Martha Street', 'Sanders', 'AZ', '86512')," +
                "('Kevin', 'Smith', '232838282', '9142382727', 'kevin.smith@freespace.com', 'Shobe Lane', 'Mesa Verde National', 'CO', '81330')," +
                "('Tomas', 'Louis', '235828129', '9142344930', 'tomas.louis@freespace.com', 'Nickel Road', 'Los Angeles', 'CA', '90017')," +
                "('Synthia', 'Jenkins', '637282172', '8452920293', 'synthia.jenkins@freespace.com', 'Seneca Drive', 'Portland', 'OR', '97232')," +
                "('Sherry', 'Na', '273829282', '8456273823', 'sherry.na@freespace.com', 'Elsie Drive', 'Canistota', 'SD', '57012')," +
                "('Lucile', 'Curci', '938276212', '9412328473', 'lucile.curci@freespace.com', 'Cody Ridge Road', 'Clinton', 'OK', '73601')," +
                "('Emma', 'Deal', '231234948', '9145627364', 'emma.deal@freespace.com', 'Nutters Barn Lane', 'Colfax', 'IA', '50054')," +
                "('Jean', 'Edwards', '238349212', '8456734676', 'jean.edwards@freespace.com', 'Olive Street', 'Johnsville', 'OH', '44902')," +
                "('Lawrence', 'Johnson', '847585736', '8456738290', 'lawrence.johnson@freespace.com', 'Huntz Lane', 'Lawrence', 'MA', '11840')," +
                "('Roberta', 'Hughes', '234938272', '9145628377', 'roberta.hughes@freespace.com', 'Young Road', 'Minidoka', 'ID', '83343')," +
                "('Linda', 'Olive', '238464292', '9173826477', 'linda.olive@freespace.com', 'Black Stallion Road', 'Lexington', 'KY', '40503')," +
                "('David', 'Michaelson', '839263657', '9172837484', 'davind.michaelson@freespace.com', 'Baker Avenue', 'Dallas', 'TX', '75201')," +
                "('Sarah', 'Monoy', '281273828', '9145723737', 'sarah.monoy@freespace.com', 'Lyndon Street', 'Philadelphia', 'PA', '19107')," +
                "('Bruce', 'Kennedy', '837282374', '8456372819', 'bruce.kennedy@freespace.com', 'Lang Avenue', 'Escalante', 'UT', '84726')," +
                "('Milton', 'Davis', '483293484', '9174647387', 'milton.davis@freespace.com', 'Ford Street', 'Oakland', 'CA', '94612')," +
                "('Francis', 'Cope', '283647838', '9146572838', 'Francis.cope@freespace.com', 'Elm Drive', 'New York', 'NY', '10011')," +
                "('Dennis', 'Lafever', '474838282', '8457378490', 'dennis.lafever@freespace.com', 'Bubby Drive', 'Lockhart', 'TX', '52698')," +
                "('James', 'Pinto', '373826372', '8172638920', 'james.pinto@freespace.com', 'Pearlman Avenue', 'North Billerica', 'MA', '21862')," +
                "('Karina', 'Hollins', '846372819', '9145738292', 'karina.hollins@freespace.com', 'Desert Broom Court', 'Rutherford', 'NJ', '17070')";
    }


    public static abstract class Employee implements BaseColumns {
        public static final String TABLE_NAME = "EMPLOYEE";
        public static final String EMPLOYEE_ID = _ID;
        public static final String FIRST_NAME = "FirstName";
        public static final String LAST_NAME = "LastName";
        public static final String SSN = "SSN";
        public static final String JOB_DESCRIPTION = "JobDescription";
        public static final String PHONE_NUMBER = "PhoneNumber";
        public static final String EMAIL = "Email";
        public static final String ADDRESS = "Address";
        public static final String CITY = "City";
        public static final String STATE = "State";
        public static final String ZIP = "Zip";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                EMPLOYEE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                FIRST_NAME + " TEXT NOT NULL," +
                LAST_NAME + " TEXT NOT NULL," +
                SSN + " TEXT NOT NULL," +
                JOB_DESCRIPTION + " TEXT NOT NULL," +
                PHONE_NUMBER + " TEXT NOT NULL," +
                EMAIL + " TEXT NOT NULL," +
                ADDRESS + " TEXT NOT NULL," +
                CITY + " TEXT NOT NULL," +
                STATE + " TEXT NOT NULL," +
                ZIP + " TEXT NOT NULL," +
                " UNIQUE (" + SSN + ")," +
                " UNIQUE (" + EMAIL + ")" +
                " )";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String INITIAL_INSERT = "INSERT INTO " + TABLE_NAME +
                "(" + FIRST_NAME + ", " + LAST_NAME + ", " + SSN + ", " + JOB_DESCRIPTION +
                ", " + PHONE_NUMBER + ", " + EMAIL + ", " + ADDRESS + ", " + CITY +
                ", " + STATE + ", " + ZIP + ")" +
                " VALUES " +
                "('Justin', 'Sala', '123456876', 'Flight Attendent', '7189484593', 'jsala@gmail.com','4859 Reynolds Ave', 'Yonkers', 'NY', '10461')," +
                "('David', 'Mici', '123454963', 'Pilot Captain', '6469484593', 'dmici@yahoo.com','5938 Bear St', 'Bronx', 'NY', '10473')," +
                "('Ingrid', 'Duncan', '123429789', 'Flight Attendent', '3479484593', 'iduncan@hotmail.com','948 Lighting St ', 'Pelham', 'NY', '10472')," +
                "('Luisa', 'Knowles', '123456488', 'Flight Attendent', '9174854593', 'lknowles@yahoo.com','3347  Chariot Blvd', 'Yonkers', 'NY', '10463')," +
                "('Chris', 'Perez', '123457739', 'Flight Attendent', '7189846593', 'cperez@gmail.com','2623 Kings Street', 'Bronx', 'NY', '10469')," +
                "('Sam', 'Maglorie', '123456723', 'Pilot First Officer', '6469484356', 'smaglorie@gmail.com','329 Amsterdam Ave', 'New York', 'NY', '10023')," +
                "('Tamara', 'Hall', '123456456', 'Flight Attendent', '9179493463', 'thall@yahoo.com','333 Crow', 'Bronx', 'NY', '10473')," +
                "('Joe', 'Camacho', '198456789', 'Secret Service', '9178854593', 'jcamacho@hotmail.com','189th street', 'New York', 'NY', '10012')," +
                "('Nicole', 'Rivera', '156456789', 'Flight Attendent', '9179494893', 'nriver@gmail.com','85th street', 'New York', 'NY', '10003')," +
                "('Manny','Prithwis', '234567891','Pilot Captain', '3939997062', 'dprithwis@gmail.com','309 Bayberry Drive','Hollywood','FL', '33020')," +
                "('Anita','Serra', '246813579','Secret Service', '4992876785','aserra@gmail.com','970 Durham Road','Kansas City','MO', '64151')," +
                "('Jose', 'Law', '975319437','Flight Attendent', '2921598344' ,'jlaw@gmail.com','38 James Street','Beaver Falls','PA', '15010')," +
                "('Richard','Snow', '374284956','Pilot First Officer', '2931138862' ,'rsnow@gmail.com','72 2nd Street North','Highland Park','NJ', '18043')," +
                "('Tiffany','Chowdhury', '563825924','Pilot Captain', '5431466211' ,'tchowdhury@gmail.com','472 2nd Street','Bettendorf','IL', '60035')," +
                "('Patrick', 'Dickinson', '337594856','Flight Attendent', '8714675068','pdickinson@gmail.com','656 9th Street West','Bethesda','IA', '52722')," +
                "('Sal','Sullivan', '759923746','Pilot First Officer', '6334969695' ,'ssullivan@gmail.com','631 Winding Way','Rockaway','MD', '20814')," +
                "('Marcus','Mayers', '446357785','Flight Attendent', '8476628557' ,'mmayers@gmail.com','278 West Avenue ','Urbandale','NJ', '17866')," +
                "('Ralphy','Pannullo', '212398785','Pilot First Officer', '9396827543','rpannullo@gmail.com','287 5th Street South','Voorhees','IA', '50322')," +
                "('Rita','Jain', '374656565','Pilot Captain', '8373197295' ,'rjain@gmail.com','331 Washington Avenue','Henrico','VA', '23228')," +
                "('Franklin','Rogers', '664534273','First Attendent', '9776559481','frogers@gmail.com','11.536 12th Street East','Manchester Township','NJ', '18759')";
    }

    public static abstract class FlightDescription implements BaseColumns {

        public static final String TABLE_NAME = "FLIGHT_DESCRIPTION";
        public static final String FLIGHT_NUMBER = _ID;
        public static final String DEPARTURE = "Departure";
        public static final String DEPARTURE_CITY = "DepartCity";
        public static final String DEPARTURE_STATE = "DepartState";
        public static final String DEPARTURE_TIME = "TimeOfDeparture";
        public static final String ARRIVAL = "Arrival";
        public static final String ARRIVAL_CITY = "ArrCity";
        public static final String ARRIVAL_STATE = "ArrState";
        public static final String ARRIVAL_TIME = "TimeOfArrival";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                FLIGHT_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                DEPARTURE + " TEXT NOT NULL," +
                DEPARTURE_CITY + " TEXT NOT NULL," +
                DEPARTURE_STATE + " TEXT NOT NULL," +
                DEPARTURE_TIME + " TEXT NOT NULL," +
                ARRIVAL + " TEXT NOT NULL," +
                ARRIVAL_CITY + " TEXT NOT NULL," +
                ARRIVAL_STATE + " TEXT NOT NULL," +
                ARRIVAL_TIME + " TEXT NOT NULL" +
                " )";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String INITIAL_INSERT = "INSERT INTO " + TABLE_NAME +
                "(" + DEPARTURE + ", " + DEPARTURE_CITY + ", " + DEPARTURE_STATE + ", " + DEPARTURE_TIME +
                ", " + ARRIVAL + ", " + ARRIVAL_CITY + ", " + ARRIVAL_STATE + ", " + ARRIVAL_TIME + ")" +
                " VALUES " +
                "('LAX', 'Los Angeles', 'CA', '16:00', 'JFK', 'New York', 'NY', '20:00')," +
                "('ATL', 'Atlanta', 'GA', '08:00', 'LAS', 'Las Vegas', 'NV', '11:00')," +
                "('EWR', 'Newark', 'NJ', '06:00', 'SEA', 'Seattle', 'WA', '10:30')," +
                "('ABQ', 'Albuquerque', 'NM', '10:30', 'LGA', 'New York', 'NY', '15:30')," +
                "('HPN', 'White Plains', 'NY', '12:00', 'CLE', 'Cleveland', 'OH', '14:00')," +
                "('CLE', 'Cleveland', 'OH', '16:00', 'DAL', 'Dallas', 'TX', '15:00')," +
                "('DAL', 'Dallas', 'TX', '16:30', 'SFO', 'San Francisco', 'CA', '14:30')," +
                "('OAJ', 'Jacksonville', 'NC', '09:00', 'CLT', 'Charlotte', 'NC', '10:30')," +
                "('CLT', 'Charlotte', 'NC', '12:00', 'PHL', 'Philadelphia', 'PA', '14:00')," +
                "('PHL', 'Philadelphia', 'PA', '16:30', 'JFK', 'New York', 'NY', '19:00')," +
                "('HPN', 'White Plains', 'NY', '05:00', 'BOS', 'Boston', 'MA', '07:00')," +
                "('BOS', 'Boston', 'MA', '09:00', 'IAH', 'Houston', 'TX', '11:00')," +
                "('IAH', 'Houston', 'TX', '13:30', 'MCO', 'Orlando', 'FL', '16:30')," +
                "('MCO', 'Orlandon', 'FL', '20:30', 'ATL', 'Atlanta', 'GA', '22:00')," +
                "('ATL', 'Atlanta', 'GA', '22:45', 'BDL', 'Hartford', 'CT', '01:00')," +
                "('BDL', 'Hartford', 'CT', '07:30', 'CVG', 'Cincinnati', 'KY', '10:30')," +
                "('CVG', 'Cincinnati', 'KY', '12:30', 'BUR', 'Burbank', 'CA', '11:30')," +
                "('BUR', 'Burbank', 'CA', '14:30', 'ANC', 'Anchorage', 'AK', '17:00')," +
                "('ANC', 'Anchorage', 'AK', '08:30', 'SAN', 'San Diego', 'CA', '11:30')," +
                "('SAN', 'San Diego', 'CA', '13:45', 'HNL', 'Honolulu', 'HI', '17:00')," +
                "('HNL', 'Honolulu', 'HI', '06:30', 'PDX', 'Portalnd', 'OR', '10:45')," +
                "('PDX', 'Portland', 'OR', '13:00', 'DEN', 'Denver', 'CO', '16:30')," +
                "('DEN', 'Denver', 'CO', '18:00', 'AUS', 'Austin', 'TX', '20:30')," +
                "('AUS', 'Austin', 'TX', '21:30', 'MIA', 'Miami', 'FL', '23:45')";
    }

    public static abstract class EmployeeSchedule implements BaseColumns {
        public static final String TABLE_NAME = "EMPLOYEE_SCHEDULE";
        public static final String SCHEDULE_ID = _ID;
        public static final String EMPLOYEE_ID = "EmployeeID";
        public static final String FLIGHT_NUMBER = "FlightNumber";
        public static final String DATE = "Date";
        public static final String SHIFT_LENGTH = "ShiftLength";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                SCHEDULE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                EMPLOYEE_ID + " INTEGER NOT NULL," +
                FLIGHT_NUMBER + " INTEGER NOT NULL," +
                DATE + " TEXT NOT NULL," +
                SHIFT_LENGTH + " TEXT NOT NULL," +
                " FOREIGN KEY (" + EMPLOYEE_ID + ") REFERENCES " + Employee.TABLE_NAME + "(" + Employee.EMPLOYEE_ID + ")," +
                " FOREIGN KEY (" + FLIGHT_NUMBER + ") REFERENCES " + FlightDescription.TABLE_NAME + "(" + FlightDescription.FLIGHT_NUMBER + ")" +
                " )";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String INITIAL_INSERT = "INSERT INTO " + TABLE_NAME +
                "(" + EMPLOYEE_ID + ", " + FLIGHT_NUMBER + ", " + DATE + ", " + SHIFT_LENGTH + ")" +
                " VALUES " +
                "(1, 1, '2015-12-09', '2 Hrs')," +
                "(3, 1, '2015-12-09', '2 Hrs')," +
                "(2, 1, '2015-12-09', '2 Hrs')," +
                "(6, 1, '2015-12-09', '2 Hrs')," +
                "(1, 1, '2015-12-09', '2 Hrs')," +
                "(3, 1, '2015-12-09', '2 Hrs')," +
                "(2, 1, '2015-12-09', '2 Hrs')," +
                "(6, 1, '2015-12-09', '2 Hrs')," +
                "(4, 2, '2015-12-09', '3 Hrs')," +
                "(5, 2, '2015-12-09', '3 Hrs')," +
                "(10, 2, '2015-12-09', '3 Hrs')," +
                "(13, 2, '2015-12-09', '3 Hrs')," +
                "(4, 3, '2015-12-09', '1.5 Hrs')," +
                "(5, 3, '2015-12-09', '1.5 Hrs')," +
                "(10, 3, '2015-12-09', '1.5 Hrs')," +
                "(13, 3, '2015-12-09', '1.5 Hrs')," +
                "(7, 4, '2015-12-09', '2.15 Hrs')," +
                "(8, 4, '2015-12-09', '2.15 Hrs')," +
                "(9, 4, '2015-12-09', '2.15 Hrs')," +
                "(11, 4, '2015-12-09', '2.15 Hrs')," +
                "(12, 4, '2015-12-09', '2.15 Hrs')," +
                "(15, 4, '2015-12-09', '2.15 Hrs')," +
                "(14, 4, '2015-12-09', '2.15 Hrs')," +
                "(16, 4, '2015-12-09', '2.15 Hrs')," +
                "(7, 5, '2015-12-10', '3 Hrs')," +
                "(9, 5, '2015-12-10', '3 Hrs')," +
                "(14, 5, '2015-12-10', '3 Hrs')," +
                "(16, 5, '2015-12-10', '3 Hrs')," +
                "(12, 6, '2015-12-10', '2 Hrs')," +
                "(15, 6, '2015-12-10', '2 Hrs')," +
                "(18, 6, '2015-12-10', '2 Hrs')," +
                "(19, 6, '2015-12-10', '2 Hrs')," +
                "(20, 6, '2015-12-10', '2 Hrs')," +
                "(8, 6, '2015-12-10', '2 Hrs')," +
                "(17, 7, '2015-12-10', '2.5 Hrs')," +
                "(20, 7, '2015-12-10', '2.5 Hrs')," +
                "(18, 7, '2015-12-10', '2.5 Hrs')," +
                "(19, 7, '2015-12-10', '2.5 Hrs')";
    }

    public static abstract class Billing implements BaseColumns {
        public static final String TABLE_NAME = "BILLING";
        public static final String TRANSACTION_NUMBER = _ID;
        public static final String FLIGHT_NUMBER = "FlightNumber";
        public static final String CUSTOMER_ID = "CustomerID";
        public static final String TICKET_NUMBER = "TicketNumber";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                TRANSACTION_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                FLIGHT_NUMBER + " INTEGER NOT NULL," +
                CUSTOMER_ID + " INTEGER NOT NULL," +
                TICKET_NUMBER + " INTEGER NOT NULL," +
                " FOREIGN KEY (" + FLIGHT_NUMBER + ") REFERENCES " + FlightDescription.TABLE_NAME + "(" + FlightDescription.FLIGHT_NUMBER + ")," +
                " FOREIGN KEY (" + CUSTOMER_ID + ") REFERENCES " + Customer.TABLE_NAME + "(" + Customer.CUSTOMER_ID + ")" +
                " )";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String INITIAL_INSERT = "INSERT INTO " + TABLE_NAME +
                "(" + FLIGHT_NUMBER + ", " + CUSTOMER_ID + ", " + TICKET_NUMBER + ")" +
                " VALUES " +
                "(1, 1, 2016)," +
                "(2, 2, 2017)," +
                "(3, 3, 2018)," +
                "(4, 4, 2019)," +
                "(5, 5, 2020)," +
                "(6, 6, 2021)," +
                "(7, 7, 2022)," +
                "(1, 8, 2023)," +
                "(2, 9, 2024)," +
                "(3, 10, 2025)," +
                "(4, 11, 2026)," +
                "(5, 12, 2027)," +
                "(6, 13, 2028)," +
                "(7, 14, 2029)," +
                "(1, 15, 2030)," +
                "(2, 16, 2031)," +
                "(3, 17, 2032)," +
                "(4, 18, 2033)," +
                "(5, 19, 2034)," +
                "(6, 20, 2035)";
    }

    public static abstract class Aircraft implements BaseColumns {
        public static final String TABLE_NAME = "AIRCRAFT";
        public static final String VIN = _ID;
        public static final String FLIGHT_NUMBER = "FlightNumber";
        public static final String MODEL = "Model";
        public static final String CREW_CAPACITY = "CrewCapacity";
        public static final String FUEL_RANGE = "FuelRange";
        public static final String FIRST_CLASS = "FirstClass";
        public static final String BUSINESS_CLASS = "BusinessClass";
        public static final String ECONOMY_CLASS = "EconomyClass";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                VIN + " TEXT PRIMARY KEY NOT NULL," +
                FLIGHT_NUMBER + " INTEGER NOT NULL," +
                MODEL + " TEXT NOT NULL," +
                CREW_CAPACITY + " INTEGER NOT NULL," +
                FUEL_RANGE + " TEXT NOT NULL," +
                FIRST_CLASS + " INTEGER NOT NULL," +
                BUSINESS_CLASS + " INTEGER NOT NULL," +
                ECONOMY_CLASS + " INTEGER NOT NULL," +
                " FOREIGN KEY (" + FLIGHT_NUMBER + ") REFERENCES " + FlightDescription.TABLE_NAME + "(" + FlightDescription.FLIGHT_NUMBER + ")" +
                " )";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String INITIAL_INSERT = "INSERT INTO " + TABLE_NAME +
                "(" + VIN + ", " + FLIGHT_NUMBER + ", " + MODEL + ", " + CREW_CAPACITY +
                "," + FUEL_RANGE + ", " + FIRST_CLASS + ", " + BUSINESS_CLASS + ", " + ECONOMY_CLASS + ")" +
                " VALUES " +
                "('ZDM1XBMV4CB527053', 1, 'Boeing 747', 10, '7,365mi', 20, 140, 216)," +
                "('1D3HW28K76S591323', 2, 'BOEING 757-300 (75Y)', 8, '3,228mi', 24, 32, 178)," +
                "('1B4GP44R1TB425064', 3, 'BOEING 777-200ER', 8, '8,542mi', 37, 36,218)," +
                "('1FTSW31S9YEE58983', 4, 'Boeing 747', 10, '7,365mi', 20, 140, 216)," +
                "('ZDM1RB8S52B055115', 5, 'Boeing 717', 4, '1,510mi', 10, 0, 100)," +
                "('1G1ZF5E73CF319847', 6, 'BOEING 757-200 (757)', 6, '3,393mi', 24, 20, 136)," +
                "('1FABP40E8HF117217', 7, 'BOEING 767-300 (76Q/P)',6, '3,515mi', 30, 28, 203)," +
                "('WVWGV7AJ8AW050840', 8, 'Boeing 717', 4, '1,510mi', 12, 20, 78)," +
                "('2G4WE567751361617', 9, 'AIRBUS A330-200 (332)', 10, '6,353mi', 34, 32, 168)," +
                "('3C6UR5FL9DG606007', 10, 'EMBRAER E170', 4, '1,800mi', 9, 12, 48)," +
                "('YV1LS5720V2401212', 11, 'Boeing 737-800', 6, '4,500mi', 20, 25, 100)," +
                "('WD2YD642335097898', 12, 'MCDONNELL DOUGLAS MD-90',5,'1,992mi',16, 15, 129)," +
                "('2HSFHAST2SC008183', 13, 'EMBRAER E175-SHUTTLE AMERICA', 4, '1,800mi', 12, 12, 52)," +
                "('1GBK6P1B5LV110036', 14, 'EMBRAER ERJ145', 4, '1,496mi', 0, 0, 50)," +
                "('1G2AS8713EL277537', 15, 'AIRBUS A330-300 (333)', 8, '5,343mi', 34, 40, 219)," +
                "('1GC4KXBG3AFA42937', 16, 'BOEING 757-200 (75M)', 4, '2,854mi', 22, 18, 141)," +
                "('1FTEX2769VNC82351', 17, 'BOEING 757-200 (75H)', 6, '4,344mi', 20, 29, 150)," +
                "('1GYUKKEF9AR102120', 18, 'BOEING 757-200 (75S)', 4, '4,705mi', 16, 44, 108)," +
                "('JM3ER2C56B0312302', 19, 'BOEING 757-200 (75X)', 4, '3,393mi', 26, 26, 132)," +
                "('1XKAD29X6VR657915', 20, 'BOEING 737-800 (738)', 4, '2,930mi', 16, 18, 126)," +
                "('19UUA9F23CA815059', 21, 'BOEING 747-400 (744)', 10, '7,365mi', 48, 42, 286)," +
                "('2WLPCD2H5YK975701', 22, 'BOEING 757-200 (75S)', 4, '4,705mi', 16, 44, 108)," +
                "('1HTSAZPM2PH494671', 23, 'MCDONNELL DOUGLAS MD-90',5,'1,992mi',16, 15, 129)," +
                "('JHMEH6264RS068014', 24, 'EMBRAER ERJ145', 4, '1,496mi', 0, 0, 50)";
    }

    public static abstract class Seating implements BaseColumns {
        public static final String TABLE_NAME = "SEATING";
        public static final String CUSTOMER_ID = "CustomerId";
        public static final String FLIGHT_NUMBER = "FlightNumber";
        public static final String SEAT_NUMBER = "SeatNumber";
        public static final String COST = "Cost";
        public static final String CLASS = "SeatClass";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                CUSTOMER_ID + " INTEGER NOT NULL," +
                FLIGHT_NUMBER + " INTEGER NOT NULL," +
                SEAT_NUMBER + " TEXT NOT NULL," +
                COST + " INTEGER NOT NULL," +
                CLASS + " TEXT NOT NULL," +
                " FOREIGN KEY (" + CUSTOMER_ID + ") REFERENCES " + Customer.TABLE_NAME + "(" + Customer.CUSTOMER_ID + ")," +
                " FOREIGN KEY (" + FLIGHT_NUMBER + ") REFERENCES " + FlightDescription.TABLE_NAME + "(" + FlightDescription.FLIGHT_NUMBER + ")," +
                " UNIQUE (" + FLIGHT_NUMBER + ", " + SEAT_NUMBER + ")" +
                " )";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String INITIAL_INSERT = "INSERT INTO " + TABLE_NAME +
                "(" + CUSTOMER_ID + ", " + FLIGHT_NUMBER + ", " + SEAT_NUMBER +
                "," + COST + ", " + CLASS + ")" +
                " VALUES " +
                "(1,1,'10A',240, 'First')," +
                "(2,2,'20A',210, 'First')," +
                "(3,3,'30A',150, 'Business')," +
                "(4,4,'41B',160, 'Business')," +
                "(5,5,'11B',260, 'First')," +
                "(6,6,'10A',240, 'First')," +
                "(7,7,'22C',230, 'First')," +
                "(8,1,'22C',230, 'First')," +
                "(9,2,'23D',210, 'First')," +
                "(10,3,'50A',130, 'Business')," +
                "(11,4,'50B',150, 'Business')," +
                "(12,5,'41B',160, 'Business')," +
                "(13,6,'42C',160, 'Business')," +
                "(14,7,'20A',210, 'First')," +
                "(15,1,'21B',230, 'First')," +
                "(16,2,'22C',230, 'First')," +
                "(17,3,'23D',210, 'First')," +
                "(18,4,'60A',120, 'Economy')," +
                "(19,5,'70A',120, 'Economy')," +
                "(20,6,'80A',120, 'Economy')";
    }

}
