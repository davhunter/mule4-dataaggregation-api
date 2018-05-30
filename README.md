# mule4-dataaggregation-api

Demo API that is responsible for aggregating data from a number of *other* APIs, and returning the full list of results. It's implemented in **Mule4** / **Studio7**.

## Features

The following features are used in this project:

### Derby

Configuration data -- the list of APIs to call for data -- is stored in an in-memory **Derby** database.

### Spring

Mule4 changes the way that it works with **Spring** under the covers. The main reason is to decouple the version of Spring being used from the underlying Runtime implementation.

This means that using Spring objects/concepts has changed to a multi-step process:

1. Import the **Mule Spring Module** in the POM
1. Import the desired version of Spring in the POM, both in the `dependencies` section as well as in the `build / plugins / plugin / mule-maven-plugin / configuration / sharedLibraries` section.
1. Create a Spring XML file
1. Create a global Spring Config, pointing to that XML file
