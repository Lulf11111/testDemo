package com.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ZhongJie implements MethodInterceptor {

	// ��ȡ�������˵Ķ���
	public Object getInstance(Object obj) throws Exception {
		// ͨ��������Ƹ���ʵ����
		Enhancer enhancer= new Enhancer();
		// �Ѹ�������Ϊĳ��
		// ��һ�����Ǹ���cglib�����ɵ�������Ҫ�̳��ĸ�����
		enhancer.setSuperclass(obj.getClass());
		// ���ûص�
		enhancer.setCallback(this);
		// ����Դ���� ����class�ļ� ���ص�JVM�ļ������ҷ��ر���������
		return enhancer.create();
	}

	// ͬ��������һ���ֽ���������һ����
	// ����ʹ��api���û��������޸�֪��
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("�����н� CQ");
		// ���obj����������CGLib������new������
		// cglib new�����Ժ�Ķ����Ǳ��������������(�����������Լ�д���Ǹ���)
		// OOP����new����֮ǰ��ʵ����Ĭ���ȵ���������super()������
		// new�������ͬʱ��������new��������,����൱�ڼ�ӵĳ��������Ǹ��������
		// ������д�˸�������з���
		// ���Ǹı���������ĳЩ���ԣ��ǿ��Լ�ӵز������������
		proxy.invokeSuper(obj, args);
		return null;
	}

}