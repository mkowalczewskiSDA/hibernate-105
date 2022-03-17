package com.sda.hibernate.model;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class EntityInfo {

    LocalDateTime timeWhenRowWasAdded;

}
