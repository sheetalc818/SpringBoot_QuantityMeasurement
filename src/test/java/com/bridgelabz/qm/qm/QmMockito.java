package com.bridgelabz.qm.qm;

import com.bridgelabz.qm.qm.controller.QmController;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.service.IQmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(QmController.class)
public class QmMockito {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    private IQmService qmService;

    @Test
    public void get_allMainUnits_returnsOkWithListOfMainUnits() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/quantityMeasurement/unit/type")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void get_allSubUnits_returnsOkWithListOfSubUnitsRelatedToMainUnit() throws Exception {
        List<ConversionUnitType> unitTypeList = Arrays.stream(ConversionUnitType.values()).filter(unitType -> unitType.unit.equals(TypeOfUnits.VOLUME)).collect(Collectors.toList());
        given(qmService.getUnitType(TypeOfUnits.VOLUME)).willReturn(unitTypeList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/quantityMeasurement/unit/subtype?unit={unit}", TypeOfUnits.VOLUME)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(unitTypeList)));
    }

    @Test
    public void givenUnits_AfterConversion_ShouldReturnValidConversionValueInRespectedUnit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/quantityMeasurement/unit/conversion")
                //.content(asJsonString(new QmDTO(FEET,INCHES,1)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
