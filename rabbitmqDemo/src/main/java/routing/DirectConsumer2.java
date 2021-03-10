package routing;

import com.rabbitmq.client.*;
import rabbitMqUtil.RabbitMqUtil;

import java.io.IOException;

/**
 * @ClassName DirectConsumer2
 * @Description 路由版订阅模式
 * @Author cailun
 */
public class DirectConsumer2 {

    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs_direct","direct");
        String queue = channel.queueDeclare().getQueue();
        String routingKey = "error";
        channel.queueBind(queue,"logs_direct",routingKey);
        channel.basicConsume(queue,true,new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println(new String(body));
            }
        });


    }
}
