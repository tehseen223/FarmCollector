1.  run the springbootapplication i.e. FarmCollectorApplication class or use mvn spring-boot:run
.

2. open the url http://localhost:8080/h2-console and change DB URL to jdbc:h2:file:./data/farmdb with username : sa and password : password

3. run below query .. 
INSERT INTO farm (id, name) VALUES (1, 'MyFarm');
INSERT INTO season (id, name) VALUES (1, 'Spring2024');


4. now use postman to call below API . 

[POST] http://localhost:8080/api/v1/planted 
Payload Example: 

{
  "farmName": "MyFarm",
  "season": "Spring2024",
  "fieldName": "Field1",
  "cropType": "Corn",
  "plantingArea": 10,
  "expectedProduct": 20
}

5. use postman to call Harvested API. 
[POST] http://localhost:8080/api/v1/harvested
Payload Example: 

{
  "farmName": "MyFarm",
  "season": "Spring2024",
  "fieldName": "Field1",
  "cropType": "Corn",
  "actualHarvestedProduct": 18
}


6. Open the browser and hit the below URL to see the reports. 

http://localhost:8080/api/v1/reports/farms. 

http://localhost:8080/api/v1/reports/crops. 
