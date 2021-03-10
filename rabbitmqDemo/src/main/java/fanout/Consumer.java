package fanout;

import com.rabbitmq.client.*;
import rabbitMqUtil.RabbitMqUtil;

import java.io.IOException;

/**
 * @ClassName Consumer
 * @Description 消费者一号
 * @Author cailun
 */
public class Consumer {

    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        //通道绑定交换机
        channel.exchangeDeclare("logs","fanout");

        //获取临时队列
        String queue = channel.queueDeclare().getQueue();

        //通过通道将叫交换机和队列进行绑定----fanout 路由key没什么效果
        channel.queueBind(queue,"logs","");

        //消费消息                           队列名，消息是否确认，回调
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(new String(body));
            }
        });

    }
}
