package com.example.mycalculator

import com.example.mycalculator.main.CalcMainLogic
import com.example.mycalculator.main.OperationPercent
import com.example.mycalculator.main.Operations
import org.junit.Assert
import org.junit.Test

class OperationsUnitTests {
    private val calcMainLogic = CalcMainLogic()


    @Test
    fun testOperationPlus_True_Result() {
        Assert.assertEquals(7.0, 7.0, calcMainLogic.oper(3.0, 4.0, Operations.PLUS))
    }

    @Test
    fun testOperationPlus_Wrong_Result() {
        Assert.assertNotEquals(10.0, calcMainLogic.oper(3.0, 4.0, Operations.PLUS))
    }

    @Test
    fun testOperationMinus_True_Result() {
        Assert.assertEquals(7.0, 7.0, calcMainLogic.oper(10.0, 3.0, Operations.MINUS))
    }

    @Test
    fun testOperationMinus_False_Result() {
        Assert.assertNotEquals(15.0, calcMainLogic.oper(10.0, 3.0, Operations.MINUS))
    }

    @Test
    fun testOperationMul_True_Result() {
        Assert.assertEquals(8.0, 8.0, calcMainLogic.oper(2.0, 4.0, Operations.MUL))
    }

    @Test
    fun testOperationMul_False_Result() {
        Assert.assertNotEquals(100, calcMainLogic.oper(5.0, 10.0, Operations.MUL))
    }

    @Test
    fun testOperationDiv_True_Result() {
        Assert.assertEquals(8.0, 8.0, calcMainLogic.oper(16.0, 2.0, Operations.DIV))
    }

    @Test
    fun testOperationDiv_Wrong_Result() {
        Assert.assertNotEquals(12.0, calcMainLogic.oper(40.0, 2.0, Operations.DIV))
    }

    @Test
    fun testOperationPercentPlus_True_Result() {
        Assert.assertEquals(
            110.0,
            110.0,
            calcMainLogic.operPercent(100.0, 10.0, OperationPercent.PLUS)
        )
    }

    @Test
    fun testOperationPercentPlus_False_Result() {
        Assert.assertNotEquals(50.0, calcMainLogic.operPercent(100.0, 10.0, OperationPercent.PLUS))
    }

    @Test
    fun testOperationPercentMinus_True_Result() {
        Assert.assertEquals(
            90.0,
            90.0,
            calcMainLogic.operPercent(100.0, 10.0, OperationPercent.MINUS)
        )
    }

    @Test
    fun testOperationPercentMinus_False_Result() {
        Assert.assertNotEquals(80.0, calcMainLogic.operPercent(100.0, 10.0, OperationPercent.MINUS))
    }

    @Test
    fun testOperationPercentMul_True_Result() {
        Assert.assertEquals(
            10.0,
            10.0,
            calcMainLogic.operPercent(100.0, 10.0, OperationPercent.MUL)
        )
    }

    @Test
    fun testOperationPercentMul_False_Result() {
        Assert.assertNotEquals(25.0, calcMainLogic.operPercent(100.0, 10.0, OperationPercent.MUL))
    }

    @Test
    fun testOperationPercentDiv_True_Result() {
        Assert.assertEquals(
            1000.0,
            1000.0,
            calcMainLogic.operPercent(100.0, 10.0, OperationPercent.DIV)
        )
    }

    @Test
    fun testOperationPercentDiv_False_Result() {
        Assert.assertNotEquals(100.0, calcMainLogic.operPercent(100.0, 10.0, OperationPercent.DIV))
    }
}