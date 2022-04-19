# Industry Exchange Network
This is the final year project for Tangsheng Geng at UCL, which is building an online community for IBM IXN to allow
information display and interaction among industries, students and universities.  

The application is deployed on IBM cloud using Docker and Kubernetes.  
Link: http://169.51.203.3:31514/homepage.html   

The application makes use of the IBM DB2 online database for data storage and the IBM Watson AI on Natural language processing for user input analysis.  

The project began in January, but the initial commit took place in late March. This is because the project has gone through a refactor process incorporating springboot and the old repository has been cleared. 

For examiners: there are two configuration files that are not pushed to this remote repository:
- application-datasource.yml This file contains the credentials to access IBM DB2.
- application-watson.yml This file contains the credentials to access IBM Watson AI.
