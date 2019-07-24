Deployment of Micro-service on Local machine using Docker ->


What is docker ?

=>  Docker is a tool designed to make it easier to deploy and run the application by using container.
Container - Container allow developer to package up an application with all parts it needs such as libraries and other dependencies and ship it out as one package

Why Docker ?
=> In software development we came across the problem that our piece of code will run on dev eneviorment and the same piece of code will not run on some different eneviorment like QA. 
So basically with the help docker we resolved this problem. 



How Docker works - >

  
  
																																					
  DockerFile      ->          Docker Imgae        		 ->             Docker Hub (cloud)      ->     Pull the image from docker hub
										
													|
													
										Docker Containers                                                                                                          
										-------------------------
										       VM
											   
											   
1.  Developer will create the DockerFile. 

Sample of DockerFile is as follows -

FROM openjdk:8                             ----> Java 8 version - Will get the java 8 dependencies from docker hub

EXPOSE 8080								--------> Expose the 8080 port

ADD /build/libs/dockerDemo-0.0.1-SNAPSHOT.jar dockerDemo-0.0.1-SNAPSHOT.jar   ------------> will copy new files from <src> and add them to the container's filesystem at path <dest>.

ENTRYPOINT ["java", "-jar", "dockerDemo-0.0.1-SNAPSHOT.jar"]      ------------> allows to configure a container that will run as an executable


2. By using below commnad we can build the docker image -

 docker build -f Dockerfile -t spring_docker_demo .

-> build from -f file Dockerfile (name of docker file) -t target name (name can be anything image name)  . file is in local directory 

Below is the result of this command -

ajinkya@ajinkya-HP-ProBook-640-G3:~/Demo/dockerDemo$ docker build -f Dockerfile -t spring_docker_demo .
Sending build context to Docker daemon  19.03MB
Step 1/4 : FROM openjdk:8
 ---> 27da2af61908
Step 2/4 : EXPOSE 8080
 ---> Using cache
 ---> 63fa60eab6b7
Step 3/4 : ADD /build/libs/dockerDemo-0.0.1-SNAPSHOT.jar dockerDemo-0.0.1-SNAPSHOT.jar
 ---> Using cache
 ---> ceeb48e116e0
Step 4/4 : ENTRYPOINT ["java", "-jar", "dockerDemo-0.0.1-SNAPSHOT.jar"]
 ---> Using cache
 ---> 86b32d1851e2
Successfully built 86b32d1851e2
Successfully tagged spring_docker_demo:latest

To check whether image is build or not we can use below command -
docker images

ajinkya@ajinkya-HP-ProBook-640-G3:~/Demo/dockerDemo$ docker images
REPOSITORY           TAG                 IMAGE ID            CREATED             SIZE
docker_demo          latest              86b32d1851e2        25 hours ago        507MB
spring_docker_demo   latest              86b32d1851e2        25 hours ago        507MB
<none>               <none>              9f61a2c81045        5 days ago          516MB
openjdk              8                   27da2af61908        6 days ago          488MB
couchbase            latest              b5f87c81aef1        2 weeks ago         959MB
hello-world          latest              fce289e99eb9        6 months ago        1.84kB


3. To run the application in docker container - 
 docker run -p 8080:8080 docker_demo



