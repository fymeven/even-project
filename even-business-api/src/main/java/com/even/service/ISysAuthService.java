package com.even.service;

import java.util.List;

/**
 * Created by fymeven on 2017/10/28.
 */
public interface ISysAuthService {

    List<String> selectAuthsByUserName(String userName);
}
