# mule4-dataaggregation-api

Demo API that is responsible for aggregating data from a number of *other* APIs, and returning the full list of results. It's implemented in **Mule4** / **Studio7**.

## Dependencies

This project provides the code for a **Process API** that depends on one or more **System APIs** -- the Process API calls these System APIs, and then aggregates the results. (The list of System APIs to be used by the Process API is maintained in a Derby Database, which is adminstered via an Admin API, provided by this project.)

Three such System APIs have been defined, and are used by this System API for demonstration purposes. They are defined by three separate projects, alongside this one:

* `mule4-hc-api` gets data from the Health Canada API
* `mule4-nyt-api` gets data from the New York Times API
* `twitter-system-api` gets data from the Twitter API

Overall instructions for running the demo are given here, in the `mule4-dataaggregation-api` project, but the other three projects are also required for successful execution.

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

### APIviz

Because there are some Java classes here, the **APIviz** library is used to generate nicer JavaDoc documentation. This means that **Graphviz** must also be installed on the machine where JavaDoc is generated.

The JavaDoc generation is not happening at build time, so the build machine doesn't *necessarily* need to have Graphviz installed.
