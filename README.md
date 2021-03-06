Heroku.ANY
==========

API client code generator for Heroku.

Supports ANY client language, where ANY equals Java :) Seriously though, more languages and frameworks (hopefully) to come.

Generation
----------

To view generation options, run:

    $ bin/generate --help
    
      Heroku.ANY 0.1 Super Alpha
        -f, --file       <arg>   File (doc.json) describing the API
        -g, --generator  <arg>   Generator name. Available generators: jersey-client
        -o, --output     <arg>   Output directory of generated files (default = target/generated)
            --help               Show help message
            --version            Show version of this program

Example generation:

    $ bin/generate -f path/to/doc.json -g jersey-client -o path/to/output
      OK: jersey-client

Re-installation
---------------

This is automatically built and installed when `bin/generate` is run for the first time, but to force a re-build and installation, run `bin/install`.

Development and Testing
-----------------------

To create a new generator, implement the `com.heroku.any.Generator` trait and add the fully-qualified class name to the file `src/main/resources/META-INF/services/com.heroku.any.Generator`. Any templates or static files should go in the `src/main/templates/{generator.name}` directory.

Tests can be run with `bin/sbt test`. Continuous test runs can be run with `bin/sbt ~test`.

Generated code correctness is tested with gold files. Gold files live in `src/test/goldfiles/{generator.name}` and represent what the generated code is expected to look like. When tests are run, freshly generated is diffed against the gold file and any differences are reported as errors. If a change is made to a generator that will affect the generated code, the gold files can be re-generated by running `bin/goldfiles` and should be checked in along with the change to the generator. It is recommended to separate commits that change what *what* is generated from changes *how* the code is generated. This will make the gold files an effective tool ensure refactorings to the code generator will not affect the resulting generated code.

To ensure that tests are run before each commit, this project contains a Git pre-commit hook. To install, run `bin/install-hooks`. Be sure to keep all tests very fast to keep this as an effective tool.

TODO
----

 - Clean up RichSchema interfaces
 - Remove as much logic as possible from generator
 - Explore using Mustache for templating
 - Add second generator to improve interfaces
 - Break generators into multiple modules
