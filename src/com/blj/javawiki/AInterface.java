package com.blj.javawiki;

/**
 * //TODO 添加类注释
 *
 * @author bailiangjin
 * @date 2021/4/18
 */
interface AInterface {
}

interface BInterface extends AInterface {
}


interface CInterface extends AInterface, BInterface {
}
