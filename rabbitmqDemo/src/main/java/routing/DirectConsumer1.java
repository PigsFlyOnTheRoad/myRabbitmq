package routing;

import com.rabbitmq.client.*;
import rabbitMqUtil.RabbitMqUtil;

import java.io.IOException;

/**
 * @ClassName DirectConsumer
 * @Description 路由直连消费者
 * @Author cailun
 */
public class DirectConsumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs_direct","direct");

       // String routingKet = "routingDirect";
        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,"logs_direct","info");
        channel.queueBind(queue,"logs_direct","error");

        //接收消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(java.lang.String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(new String(body));
            }
        });
    }



}
