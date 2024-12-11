# Prerequisites

### Ensure you have the following installed:

- Docker
- Docker Compose
- JMeter


# Setup and Run

### Step 1: Build the Application

`./gradlew bootJar`

### Step 2: Run with Docker Compose

`docker-compose up --build`

### Step 3: Configure database

The application connects to the PostgreSQL database using the following settings:

```
URL: jdbc:postgresql://db:5432/performance
Username: postgres
Password: postgres
```
These are defined in the application.yml and overridden by docker-compose.yml via environment variables.

### Step 4: Download JMeter and run it 
https://jmeter.apache.org/download_jmeter.cgi

Once you opened Apache JMeter you should create a Test Plan and add the following components:
- Test plan
- Thread Group
- HTTP Request Sampler (for every endpoint)
- Listeners (Summary Report and View Results Tree)


Summary report shows total information of the experiment

View results tree shows every endpoint

View results tree needs to check the errors

### Configuration for Testing:
For 10,000 Requests:
- Threads (Number of Threads): 100
- Ramp-Up Period (Seconds): 30
- Loop Count: 100

For 20,000 Requests:
- Threads (Number of Threads): 200
- Ramp-Up Period (Seconds): 60
- Loop Count: 100

For 50,000 Requests:
- Threads (Number of Threads): 500
- Ramp-Up Period (Seconds): 120 
- Loop Count: 100

### Creating HTTP-requests 

For run a test you should configure in every HTTP-requests:
- PATH: /api/fibonacci/coroutines?n=1000 (you can set your N)
- PATH: /api/fibonacci/completable-futures?n=1000 (you can set your N)
- PATH: /api/completable-futures
- PATH: /api/coroutines


- Create a Test Plan
- URL: localhost
- PORT: 8080 
- METHOD: GET
- Listeners: Summary Report and View Results Tree
- Action to be taken after a sampler error: STOP THREAD 
- Delay Thread Creation until needed