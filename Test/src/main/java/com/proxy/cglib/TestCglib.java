package com.proxy.cglib;

public class TestCglib {
	public static void main(String[] args) {
		// AOP ����(�Ŷӿ�����Ҫ����)
		// JDK�Ķ�̬������ͨ���ӿ�������ǿ��ת����
		// �����Ժ�Ĵ������󣬿���ǿ��ת��Ϊ�ӿ�
		// CGlib�Ķ�̬������ͨ������һ�����������������Ȼ����д����ķ���
		// �������ɵĶ������ǿ��ת��Ϊ�����������������ø�ֵ�����ࡣ
		try {
			Lulf obj=(Lulf)new ZhongJie().getInstance(new Lulf());
			obj.findHouse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}