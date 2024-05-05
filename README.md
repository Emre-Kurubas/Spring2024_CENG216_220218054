# Emre Kurubaş - Messaging System

## Project Overview
Messaging System is a Java-based application developed as a homework assignment for my Computer Networks class. The primary objective of the project was to create a messaging system where users could exchange messages in real-time over a network.

The application facilitates communication between users through a client-server architecture. Users can connect to the server, send messages to each other, and receive messages from other connected users.

## Technologies Used
- Language: Java
- IDE: Eclipse

## Setup Instructions
To run this project on your computer, follow these detailed steps:

1. **Clone the Repository**: 
   Clone the repository to your local machine using Git by running the following command in your terminal:
   ```
   git clone <repository_url>
   ```
   Replace `<repository_url>` with the URL of the repository.

2. **Open Eclipse IDE**:
   Ensure that you have Eclipse IDE installed on your computer. If not, download and install it from the [official website](https://www.eclipse.org/downloads/).

3. **Import the Project**:
   Open Eclipse IDE and import the project into your workspace:
   - Go to `File` > `Import`.
   - Select `General` > `Existing Projects into Workspace`.
   - Click `Next` and then browse to the directory where you cloned the repository.
   - Select the project folder and click `Finish`.

4. **Rewrite Configuration Files**:
   Before running the project, you need to rewrite the following configuration files according to your own computer settings:
   - `.gitignore`: This file specifies intentionally untracked files to ignore. Modify it as needed for your environment.
   - `.classpath`: This file contains project-specific classpath settings. Update it with your project dependencies and build configurations.
   - `.project`: This file contains project-specific configuration settings. Adjust it according to your project structure and settings.

## Note
Rewriting the mentioned configuration files (.gitignore, .classpath, .project) according to your own computer settings is crucial for the proper functioning of the application on your computer.

Additionally, please note the following:

- **Separate Modules for Server and Client**: The `com.server` and `com.client` packages need to have separate modules to function correctly. Although they are together in this repository for convenience, it's recommended to organize them into separate modules or projects for better modularity and maintainability.

  To create a module for the `com.client` project, include a `module-info.java` file inside the `com.client` package with the following content:

  ```java
  module com.client {
      requires com.server;
      requires org.apache.commons.lang3;
      requires java.desktop;
  }

## Author
Emre Kurubaş
