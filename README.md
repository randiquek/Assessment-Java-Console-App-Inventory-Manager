# Assessment-Java-Console-App-Inventory-Manager 

<h3>------Psuedocode------</h3>

<b>+Console IO Class+</b>

displayMainMenu():
- Print main menu options

printHeader(String message):
- Display a custom header message for the menu options

getInteger(String prompt):
- If input integer is valid, return result
- Else print error message that input is not valid

getDoubleInput(String prompt):
- If input double is valid, return result
- Else print error message that input is not valid

getString(String prompt):
- Prints a message to the console
- Takes a string input

<b>+Product Class+</b>

addStock(int quantity)
- Takes in an int amount and adds to value of the quantity

removeStock(int quantity): 
- If quantity is greater or equal to amount to remove, subtract amount from the quantity
- Else print "Not enough stock"

updatePrice(double price):
- Takes in a new price and sets current price to new price

displayProductInfo()
- Prints a product's productId, productName, quantity, and price

<b>+Product Repository Class+</b>

checkExpiry():
- Returns based on true or false 
- If current date is greater than expirationDate, print "Expired"
- Else print "Not expired"

<b>+Inventory Management Service Class+</b>

addProduct(Product):
- Create new Product List
- If product already exists, print "Item already exists"
- else create new item and set productName, quantity, and price
- Save to product repo

removeProduct():
- Find product by productName
- If product exists, remove product
- Else pring "Product does not exist

updateProduct()
- Find product by productName
- If product is present, set new name, quantity, and price, if updating all or certain attributes
- Save to Product repo
- Else print "Product not found"

displayAllProducts():
- Create new Product List and find all from product repo

searchProduct(String product):
- Create new Product List and find all products in product repo
- For every product in the list, if product equals product name, print product info
- Else print "Product not found"
