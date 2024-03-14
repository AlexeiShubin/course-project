# TeachMeSkills_C27_COURSE_PROJECT

We have created a program for processing payment documents and providing financial reporting.
Access to the program is provided by login and password.
The user has 5 attempts to enter the login and password correctly, after which the program stops working.
After confirming access, the program requests the path to the folder with financial documents, reads information from the documents and compiles statistics.
Documents in three types of folders: invoices, orders, checks. The program reads only documents in TXT format. The remaining documents are considered invalid and are recorded in a separate folder for storage. The program processes files only for 2023; other documents are considered invalid and are also saved in a separate folder. The program also checks the title of documents for typos and takes into account different case of spelling of the title.
The program implements saving logs into a separate file.
There is a division of logs: for storing general information and for storing error information.
Statistics we take into account:
- total turnover for the year
- total turnover for all invoices;
- total turnover for all orders;
- total turnover for all checks;
  
Based on the results of the program, statistics are loaded into a separate file.
