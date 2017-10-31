package com.even.service;

import java.util.Set;

/**
 * Created by fymeven on 2017/10/28.
 */
public interface ISysAuthService {

    Set<String> selectAuthsByUserName(String userName);
}
