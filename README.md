# gRPCExample

To build the examples, run in this directory:

$ ./gradlew installDist
This creates the scripts wallet-server &  wallet-client in the build/install/BetPawa_Example/bin/ directory that run the examples. 
Each example requires the server to be running before starting the client.

For example, to try the hello world example first run:

$ ./build/install/BetPawa_Example/bin/wallet-server
And in a different terminal window run:

$ ./build/install/BetPawa_Example/bin/wallet-client

Install mysql in machine with testdb database name. Please find the below DB details.

        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/testdb</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">root</property>
