# cache_service
This service is used to cache the data and has default size 10.
I have implemented four rest endpoints to use this cache service.
1. Add value to cache: POST
URL: http://localhost:8080/ccc-cache/
Request body:
{
	"key": "key",
	"value":"anything"
}

2. Get the value from Cache: GET
URL: http://localhost:8080/ccc-cache/{key}

3. Delete the value from cache: DELETE
URL: http://localhost:8080/ccc-cache/{key}

4. Clear the cache: 
URL: http://localhost:8080/ccc-cache/clear