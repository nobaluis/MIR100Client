## Overview

Communication library for the MiR 100 robot with the [MiR robot 2.0.X RES API](https://www.mobile-industrial-robots.com/media/2214/mir_robot_rest_api_200.pdf). Requires Java 8 and Maven 3.5.x.

## Usage

First you need to install this project in your local maven repository.
This can be done in several ways, by commands with maven or from any IDE (IntelliJ, Netbeans, Eclips, etc.).

For IntelliJ:
1. Open pom.xml file as a project.
2. Go to the Maven tab > Lifecycle > install.

### Maven dependencies

To include this module in your maven project just add these lines to your pom file

```xml
<dependency>
    <groupId>com.ijrobotics</groupId>
    <artifactId>MIR100Client</artifactId>
    <version>0.1</version>
</dependency>
```
