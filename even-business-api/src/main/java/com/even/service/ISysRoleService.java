package com.even.service;

import java.util.Set;

/**
 * Created by fymeven on 2017/10/28.
 */
public interface ISysRoleService {
    Set<String> selectRolesByUserName(String userName);
}
