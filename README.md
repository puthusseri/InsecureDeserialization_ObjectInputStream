# Insecure Deserialization using

Blindly using ObjectInputStream to deserialize the class can lead to RCE.
Prerequisites :
The deserialized class should be in the scope of the projects, else ClassNotFoundException will occur.
