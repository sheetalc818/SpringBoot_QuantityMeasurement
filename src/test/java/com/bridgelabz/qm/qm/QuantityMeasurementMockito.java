package com.bridgelabz.qm.qm;

import com.bridgelabz.qm.qm.controller.QuantityMeasurementController;
import com.bridgelabz.qm.qm.dto.QuantityMeasurementDTO;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.responsedto.ResponseDTO;
import com.bridgelabz.qm.qm.service.IQuantityMeasurementService;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.bridgelabz.qm.qm.enumeration.TypeOfUnits.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementMockito {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    private IQuantityMeasurementService qmService;

    Gson gson = new Gson();

    @Test
    public void get_allMainUnits_returnsOkWithListOfMainUnits() throws Exception {
        List<TypeOfUnits> unitTypeList = Arrays.asList(LENGTH,VOLUME,WEIGHT,TEMPERATURE);

        given(qmService.getAllUnits()).willReturn(unitTypeList);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/quantityMeasurement/unit/type")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        ResponseDTO responseDto = gson.fromJson(response, ResponseDTO.class);

        List<TypeOfUnits> unitsList = (List<TypeOfUnits>) responseDto.data;

        Assert.assertEquals(4,unitsList.size());
    }

    @Test
    void get_allSubUnits_returnsOkWithListOfSubUnitsRelatedToMainUnit() throws Exception {

        List<ConversionUnitType> unitTypeList = Arrays.stream(ConversionUnitType.values()).filter(unitType -> unitType.unit.equals(VOLUME)).collect(Collectors.toList());

        given(qmService.getSubUnitType(VOLUME)).willReturn(unitTypeList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/quantityMeasurement/unit/subtype?unit={unit}", VOLUME)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void givenUnits_AfterConversion_ShouldReturnValidConversionValueInRespectedUnit() throws Exception {
        QuantityMeasurementDTO convertDto = new QuantityMeasurementDTO();
        convertDto.setInitialUnit(ConversionUnitType.FEET);
        convertDto.setOutputUnit(ConversionUnitType.INCHES);
        convertDto.setActualValue(1);

        String stringConvertDto = gson.toJson(convertDto);
        double expectedConvertedValue = 12.0;

        Mockito.when(qmService.getConversionUnitValue(any())).thenReturn(expectedConvertedValue);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/quantityMeasurement/unit/conversion")
                .content(stringConvertDto)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        ResponseDTO responseDto = gson.fromJson(response, ResponseDTO.class);
        double actualConvertedValue = (double) responseDto.data;

        Assert.assertEquals(expectedConvertedValue,actualConvertedValue,0.0);
    }
}
