package com.blj.javawiki.designpattern.abstractfactory;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 下午3:17:30 
 *
 */
public class WhiteAnimalFactory implements IAnimalFactory {
    @Override
    public ICat createCat() {
        return new WhiteCat();
    }
    @Override
    public IDog createDog() {
        return new WhiteDog();
    }
}
