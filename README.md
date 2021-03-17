# Registry for buildings REST API.

H-2 in-memory database.

1. Run the project, an empty database will be created according @Entities.

2. The database is empty. Use POST endpoint for insert first data. 

3. First need to reate PropertyType with needed yearly percentage (to add to Building, when adding new) use http://localhost:8080/addpropertytype to create PropertyType. Can use this JSON:

{
    "propertyType": "Office",
    "taxPercentage": 1.5
}

and http://localhost:8080/addowner Can use this JSON:

{
    "name": "tomas"
}

4. Add building to registry using http://localhost:8080/addbuilding/{propertyTypeId}   (building will be added only with PropertyType (and Owner as NULL) you provide as @PathVariable). Use JSON:

 {
"city": "vilnius",
"street": "Ateities",
"number": 5,
"sizeInSquareMeters": 58,
"value": 52100
 }

5. Owner can be added by updating building by providing owners id (also can edit all fields including update property type: http://localhost:8080/editbuilding/{ownerId}/{propertyTypeId}  Use JSON:

 {
"buildingId": 1,
"city": "vilnius",
"street": "Ateities",
"number": 5,
"sizeInSquareMeters": 58,
"value": 52100
 }

6. Can check all endpoints with this address by Swagger: http://localhost:8080/swagger-ui.html
,or use Postman.

7. DELETING OWNER is possible when owner does not own any buildings. If you want to delete owner, first need to update building's foreign key with other owner. Same goes to Property type. 

8. You can calculate yearly tax rate of particular owner of all owned buildings by providing this endpoint with owners ID:  http://localhost:8080/ownertax/{id} 
    NOTE: if property value is under 100, program calculates fixed 1 currency amount per year.

  
