NPDS_finalProject
==============

 National College of Ireland (NCI)

 Distributed Systems (DS)
 
 Practical Assessment 3


  ## RUNNING IT

Clone this repository

    git clone https://github.com/lsilvs/DistribSyst_PraticalAssessment3
    cd DistribSyst_PraticalAssessment3

Compile all java files

    javac *.java

Start the naming service using port 1050

    tnameserv -ORBInitialPort 1050

Start the server

    java ./KamaradServer

Run the client

    java ./KamaradClient



  ## OBJECTIVE

You are required to develop an application that allows users to register for an online account with the Kamarad mobile operator. The Kamarad online account will allow users to top up their account, and to get the credit balance.

  ## SECURITY FEATURES

Instructions to generate the ID:

- Unique ID is assigned to each customer.
- The unique ID is based on a counter which is maintained by the server.
- The first registration will be assigned the ID 0001, but represented as a string.
- Subsequent registrations will be the next number in the sequence i.e. 0002, 0003, 0004 etc.
- This unique ID will also serve as the user’s password when they perform a payment.
- The username is the mobile phone number

  ## IDL

The IDL shall contain a struct KamaradAccountDetails. Note it is agreed that the structure shall change at a later stage during design. Therefore it is imperative that all information passed relating to this type shall be treated as an ANY.

  ## CLIENT

The client presents the customer with a menu:

- 1. Register for online payment
- 2. Top-up your Kamarad credit online
- 3. Get credit information
- 4. Quit

Register for on line account:
The client shall query the customer for information relating to

- name
- phone number
- address
- bank A/C number
- balance
- credit (Kamarad credit)

The client shall request the service to register for on line account from the server. Upon registration the server shall issue the customer with a secret Unique id. The Unique id shall be returned as a parameter in the service request. Note the Unique id shall be represented by a StringHolder.

Perform an online top-up (TopUpKamarad)

The client shall query the customer for their unique id and an amount of money that he/she wishes to top-up. The unique id and the amount are passed to the servant. The servant shall return the structure containing all personal details related to the unique id. The structure shall be returned as a parameter in the service request.

Get credit information (GetCreditKamarad)

The client shall query the customer for their unique id. The unique id is passed to the servant. The servant shall return the credit value related to the unique id. The credit shall be returned as a parameter (out) in the service request.

  ## SERVANT

Note a unique id will also be associated with the struct containing the Kamarad a/c details. You may choose your own unique ID for this account. The information shall be stored in a hash table whereby the unique Id acts as a key to the details in the struct.

Hashtable as data store:

The key is the unique id. The rest of the information relates to

- name
- phone number
- address
- bank A/C number
- balance
- credit (Kamarad credit)

Register for on line account

The server shall create a unique ID using the counter described above. Note that the unique ID shall be of type string.
The unique ID shall be used as a key in a hash table that points to all the data on the customer that arrives in the service request. The server shall return the unique ID to the client as a parameter in the operation.

Perform an online top-up (TopUpKamarad)

The servant shall identify the correct details in the hash table using the unique ID that arrives in the service request.
The customer’s account balance identified by the unique ID shall be decremented by the specified amount that arrived in the service request. The updated customer details shall be put back into the hashtable and shall also be returned to the client as a parameter in the service request.

Get credit information (GetCreditKamarad)

The unique ID shall be used as a key in a hash table that points to all the data on the customer that arrives in the service request. The server shall return the credit to the client as a parameter in the operation.

  ## SERVER

Note a unique id will also be associated with the struct containing the Kamarad a/c details. You may choose your own unique ID for this account. The information shall be stored in a hash table whereby the unique Id acts as a key to the details in the struct.

Hashtable as data store:
The key is the unique id. The rest of the information relates to

- name
- phone number
- address
- bank A/C number
- balance
- credit (Kamarad credit)

Register for on line account

The server shall create a unique ID using the counter described above. Note that the unique ID shall be of type string.
The unique ID shall be used as a key in a hash table that points to all the data on the customer that arrives in the service request. The server shall return the unique ID to the client as a parameter in the operation.

Perform an online top-up (TopUpKamarad)

The servant shall identify the correct details in the hash table using the unique ID that arrives in the service request.
The customer’s account balance identified by the unique ID shall be decremented by the specified amount that arrived in the service request. The updated customer details shall be put back into the hashtable and shall also be returned to the client as a parameter in the service request.

Get credit information (GetCreditKamarad)
The unique ID shall be used as a key in a hash table that points to all the data on the customer that arrives in the service request. The server shall return the credit to the client as a parameter in the operation.

  ## Server

The Server shall implement the delegation model and publish the OnLineKamarad servant in three levels