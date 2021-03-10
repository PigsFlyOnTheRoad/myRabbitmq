package workqueue;

import com.rabbitmq.client.*;
import rabbitMqUtil.RabbitMqUtil;

import java.io.IOException;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author cailun
 */
public class Consumer1 {


    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        //绑定通道
        channel.queueDeclare(
                "hello", //队列名,如果不存在就创建
                false,  //是否持久化
                false, //是否独占队列
                false,//执行完毕是否自动删除队列
                null //额外参数
        );

        channel.basicConsume(
                "hello",//消息队列名称
                true,//消息是否确认
                new DefaultConsumer(channel){   //消息回调接口
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                        super.handleDelivery(consumerTag, envelope, properties, body);
                        System.out.println(new String(body));
                    }
                });

    }
}
