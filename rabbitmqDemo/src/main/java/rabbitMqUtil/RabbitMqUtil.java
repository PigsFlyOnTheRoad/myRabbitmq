package rabbitMqUtil;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName RabbitMqUtil
 * @Description TODO
 * @Author cailun
 */
public class RabbitMqUtil {


    public static Connection getConnection(){

        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("192.168.52.128");
            connectionFactory.setUsername("ems");
            connectionFactory.setPassword("123");
            connectionFactory.setPort(5672);
            //设置连接那个虚拟主机
            connectionFactory.setVirtualHost("/ems");
            return connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection, Channel channel){
        if(null!=channel){
            try {
                channel.close();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(connection!= null){
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
