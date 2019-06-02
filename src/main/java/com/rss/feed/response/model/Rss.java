package com.rss.feed.response.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class used to unmarshall response, base XML root
 * @author MarcoMas
 *
 */
@XmlRootElement(name="rss")
public class Rss
{
    private Channel channel;

    private String version;

    public Channel getChannel ()
    {
        return channel;
    }

    public void setChannel (Channel channel)
    {
        this.channel = channel;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [channel = "+channel+", version = "+version+"]";
    }
}