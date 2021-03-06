<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [Contributing](#contributing)
  - [Building](#building)
    - [Documentation](#documentation)
    - [Dependencies](#dependencies)
      - [IntelliJ IDEA](#intellij-idea)
      - [IntelliJ Erlang](#intellij-erlang)
  - [Testing](#testing)
    - [Dependencies](#dependencies-1)
      - [[`elixir-lang/elixir`](https://github.com/elixir-lang/elixir)](#elixir-langelixirhttpsgithubcomelixir-langelixir)
        - [Installation](#installation)
      - [`intellij_elixir`](#intellij_elixir)
        - [Installation](#installation-1)
        - [Starting](#starting)
        - [Stopping](#stopping)
        - [Running automatically for tests](#running-automatically-for-tests)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# Contributing

## Building

### Documentation

The documentation files ([`CHANGELOG.md`](CHANGELOG.md), [`CONTRIBUTING.md`](CONTRIBUTING.md), [`README.md`](README.md),
and [`UPGRADING.md`](UPGRADING.md)) all have table of contents generated by
[`doctoc`](https://github.com/thlorenz/doctoc).

Install `doctoc` (globally) using `npm`

```sh
npm install -g doctoc
```

Then regenerate the table of contents using `doctoc`

```sh
doctoc .
```

### Dependencies

#### IntelliJ IDEA

An IntelliJ Platform Plugin SDK must be setup to develop plugins, but the paths are tied to the version of IntellIJ IDEA
you have installed, so you will likely need to fix the paths to match your environment.

1. File > Project Structure
2. In the “Project Structure” window
    1. Select Platform Settings > SDKs
    2. Click “+”
    3. Chose “IntelliJ Platform Plugin SDK”
    4. A modal **may** pop-up saying “Cannot Create SDK”, “You need to configure a Java SDK first”.
        1. Click OK
        2. In the “Select Home Directory for JDK” select the JDK 1.6 directory:
           “/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home”.
           **NOTE: JDK 1.6 is used, even though it is unsupported by Oracle, to give the greatest compatibility with
                   older JetBrains IDE versions**
            1. You can download [JDK 1.6 from Apple](https://support.apple.com/kb/DL1572?locale=en_US)
        3. Click OK
    5. In the “Select Home Directory for IntelliJ Platform Plugin SDK” select the IntelliJ IDEA Community Edition
       Contents: `/Applications/IntelliJ IDEA 15 CE.app/Contents`.
        **NOTE: Use Community Edition even if you have IntelliJ IDEA Ultimate Edition installed, so that the built
                plugin works with Community Edition.**
    6. In the “Select Internal Java  Platform” window
        1. Select “1.6”
        2. Click OK
    7. Select the “IntelliJ IDEA Community Edition” SDK.
        1. Select the Sourcepath tab
        2. Click the + Icon
        3. Select “~/git/JetBrains/intellij-community”
        4. In the “Detected Roots” window, click “OK” to add all roots.
    8. Click OK to close “Project Structure”

#### IntelliJ Erlang

In order to integrate with [IntelliJ Erlang](https://github.com/ignatov/intellij-erlang), we need it as a jar to access
its classes.  The ant files used to build on Travis CI can be used to download the `intellij-erlang.jar` locally too.

1. Install `ant`: `brew install ant` on OSX with Homebrew.
2. `ant -logger org.apache.tools.ant.listener.AnsiColorLogger -f intellij-elixir.xml get.idea get.intellij-erlang`

## Testing

### Dependencies

#### [`elixir-lang/elixir`](https://github.com/elixir-lang/elixir)

[`package org.elixir_lang.parser_definition.ElixirLangElixirParsingTestCase`](https://github.com/KronicDeth/intellij-elixir/blob/master/tests/org/elixir_lang/parser_definition/ElixirLangElixirParsingTestCase.java)
parses all the `*.ex` files in [`elixir-lang/elixir`](https://github.com/elixir-lang/elixir) to verify the parser works
with a realistic set of realistic files.

##### Installation

1. `mkdir ~/git`
2. `git clone git@github.com:elixir-lang/elixir.git elixir-lang/elixir`

#### `intellij_elixir`
[`org.elixir_lang.parsing_definition` tests](tests/org/elixir_lang.parsing_definition) uses
[`intellij_elixir`](https://github.com/KronicDeth/intellij_elixir)'s `IntellijElixir.Quoter` process to verify that
intellij-elixir's parsed and quoted format matches that of native Elixir's `Code.string_to_quoted`.

##### Installation

1. `mkdir ~/git/KronicDeth`
2. `cd ~/git/KronicDeth`
3. `git clone git@github.com:KronicDeth/intellij_elixir.git`
4. `cd intellij_elixir`
5. `git checkout v0.1.1`
6. `mix local.hex --force`
7. `mix deps.get`
8. `mix release`

##### Starting

For the tests to find `intellij_elixir`, `intellij_elixir` must be running locally:

1. `cd ~/git/KronicDeth/intellij_elixir`
2. `rel/intellij_elixir/bin/intellij_elixir start`

##### Stopping

After the tests are completed you can stop `intellij_elixir`:

1. `cd ~/git/KronicDeth/intellij_elixir`
2. `rel/intellij_elixir/bin/intellij_elixir stop`

##### Running automatically for tests

1. Run > Edit Configurations
2. Select JUnit > org.elixir_lang
3. Select “Unknown external tool” from the “Before launch: Make, External tool, Active tool window” from the bottom
   right pane.
4. Click the Pencil Edit icon
5. In the External Tools window
    1. Cick the + icon in the External Tools window
    2. In the Create Tool window
        1. Put “intellij_elixir” for “Name”
        2. Put “IntellijElixir.Quoter” for “Description”
        3. In the Tool Settings section
            1. For “Program” click the “…” and select
               `~git/KronicDeth/intellij_elixir/rel/intellij_elixir/bin/intellij_elixir` from the file picker.
            2. In “Parameters” put “start”
        4. Click OK to close the “Create Tool” window
    3. Click OK to close the “External Tool” window
6. Click OK to close the “Run/Debug Configurations” window
7. Click the Run arrow to run “org.elixir_lang” tests.
