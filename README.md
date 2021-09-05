# ChallengeJavaDevelopment
  > Developer: Fábio Carmelino (Software Engineer - Graduate from the University of Aveiro)
  
## Main Objectives: 
  > Development of a REST API for simple mathematical operations with 2 operands (Sum/Subtractions/Multiplication/Division)

  > Project must be separeted in atleast 2 modules (REST API and Calculator)

  > The communication between modules must use RabbitMQ and SpringAMQP

## Bonus Objectives Done:
  > Implementation of logback-access for http requests - outputed to the console and to a file named 'access.log' (path: SpringExercise/log/access.log)

  > Assignment of a unique ID to http requests and inclusion of said ID in the response's Http Headers

## How to Run:
  > 1. Run the command 'docker-compose up' inside RabbitMq's folder to launch it locally

  > 2. Run the Springboot project

  > In case that RabbitMq's queues are not created, do the following: 

    > Open in your browser: http://localhost:15672/#/ 
    > Login -> user:guest ; pw:guest
    > Go to the "Exchanges tab" and add a new exchange named "challenge.rpc"
    > Go to the "Queues tab" and add a new queue named "challenge.rpc.requests"
    > Bind the exchange to the queue

## Some References: 
  > RabbitMQ implementation based on: https://www.rabbitmq.com/tutorials/tutorial-six-spring-amqp.html

  > Logback-access configuration based on : https://github.com/akkinoc/logback-access-spring-boot-starter 

  > To set a Unique ID for http requests and forward it back to the clients: https://medium.com/@d.lopez.j/spring-boot-setting-a-unique-id-per-request-dd648efef2b
  
