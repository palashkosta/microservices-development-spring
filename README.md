# microservices-development-spring
Microservices Development
### Microservices Introduction

- Microservices = Rest + independent deployable + cloud enabled
- Microservices Challenges
  - Bounded Context
  - Configuration management
  - Dynamic scale up and scale down
  - Visibility and monitoring microservices
  - Pack of cards scenario
  - Fault tolerance

### spring cloud

- Features - Spring Cloud focuses on providing good out of box experience for typical use cases and extensibility mechanism to cover others.
 - Distributed/versioned configuration
 - Service registration and discovery
 - Routing
 - Service-to-service calls
 - Load balancing
 - Circuit Breakers
 - Global locks
 - Leadership election and cluster state
 - Distributed messaging

- Spring cloud important concepts:
  - Configuration management - 
    - Spring cloud config server
  - Dynamic scale up and scale down 
    - Naming server (Eureka)
    - Ribbon (client side load balancing) - OLD (Deprecated)
    - Spring Cloud LoadBalancer (client side load balancing) - NEW
    - Feign (Easier rest client)
  - Visibility and monitoring microservices
    - Zipkin distributed tracing
    - Netflix API gateway (zuul) - OLD (Deprecated)
    - Spring Cloud Gateway (API gateway) - NEW
  - Fault tolerance
    - Histrix - OLD (Deprecated)
    - Resilience4j - NEW for handling fault tolerance

### Microservices Advantages

- Different MS can have different technology stacks
- Dynamic scaling
- Faster release cycles

### 

