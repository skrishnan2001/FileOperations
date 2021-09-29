# FileOperations
A java package for performing basic file operations

## Files.java
Files is a class in `FileOperations` package (created by me). It contains methods for performing the basic file operations. This package can be imported in any project where you need to perform the basic file operations.

## Functionalities
- Create a new file
- Write data to a file
- Read the given file line by line
- Make a copy of an existing file
- Update the file by adding additional content to the file (appending to a file)
- Remove additional spaces  or special characters in the file and then update the file

## How to use this package?
- Clone this repo in your current project.<br />
Command: `git clone https://github.com/skrishnan2001/FileOperations.git`
- Import the necessary functions in your project.
For example, if you want to write data to a file, first import the library as<br/>
`import FileOperations.Files;`
- Then use the functionalities specified in the Files class, for example to invoke writeToFile(String, String) specified in Files class call the function like <br/>
`Files.writeToFile(fileName, data);`


