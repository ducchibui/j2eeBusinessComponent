<%@page import="javax.jms.TextMessage"%>
<%@page import="javax.jms.QueueSender"%>
<%@page import="javax.jms.Session"%>
<%@page import="javax.jms.QueueSession"%>
<%@page import="javax.jms.QueueConnection"%>
<%@page import="javax.jms.Queue"%>
<%@page import="javax.jms.QueueConnectionFactory"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message Driven Bean Page Tester</title>
    </head>
    <body>
        <p> Check the Glassfish output and try to explain what is going on ....</p>
        <%
            InitialContext jndiContext = new InitialContext();

            QueueConnectionFactory queueConnectionFactory
                    = (QueueConnectionFactory) jndiContext.lookup("jms/__defaultConnectionFactory");
            

            Queue queue = (Queue) jndiContext.lookup("jms/myQueue");

            QueueConnection queueConnection
                    = queueConnectionFactory.createQueueConnection();

            QueueSession queueSession = queueConnection.createQueueSession(false,
                    Session.AUTO_ACKNOWLEDGE);

            QueueSender queueSender = queueSession.createSender(queue);

            TextMessage message = queueSession.createTextMessage();

            for (int i = 0; i < 100; i++) {
                message.setText("This is message " + (i + 1));
                System.out.println("Sending message: " + message.getText());
                queueSender.send(message);
            }


        %>
    </body>
</html>

