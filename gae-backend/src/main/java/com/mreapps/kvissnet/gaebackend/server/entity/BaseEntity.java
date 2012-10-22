package com.mreapps.kvissnet.gaebackend.server.entity;

import com.google.appengine.api.datastore.Key;

import java.io.Serializable;

public interface BaseEntity extends Serializable
{
    Key getKey();
}