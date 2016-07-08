# Introduction

This project is to discuss and demonstrate the embedding of a spring-boot Vaadin application into a HTML page. 

The [Vaadin documentation](https://vaadin.com/docs/-/part/framework/advanced/advanced-embedding.html) describes the basics, but unfortunately the documented approach does not work for a spring-boot Vaadin application.

The Vaadin Blog article [Using CORS with Vaadin](https://vaadin.com/blog/-/blogs/using-cors-with-vaadin) is more specific and this implementation is based on that article, but the spring-boot Vaadin application did not start working.

# Forum discussions

Please follow the discussion in

- [Stackoverflow](http://stackoverflow.com/questions/38151762/embedding-vaadin-spring-boot-application-into-html)
- [the Vaadin forum](https://vaadin.com/forum#!/thread/13449342)

# Error reproduction

To reproduce the embedding error just clone this repository to your local machine, a configured Java 1.8 and Maven 3.x is required.  

## Standalone application

Just start the demo Vaadin application using the startscripts and open the application [localhost](http://localhost:8080) with the browser of your choice. 
The application starts and is usable.

## Embedded application

Open the local file 'vaadin-embed.html' in your browser. The application is loaded, but the icon font is broken, it is not possible to add text or switch the tabs.