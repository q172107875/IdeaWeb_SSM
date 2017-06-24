package com.heitian.ssm.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2017/1/2 上午12:22
 * @since JDK 1.7
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSources();
    }
}
