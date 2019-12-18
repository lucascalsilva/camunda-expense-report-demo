package com.camunda.bpm.sbexpensereportdemo.mappers;

import com.camunda.bpm.model.common.Approval;
import com.camunda.bpm.model.common.Approver;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public abstract class ApprovalMapper {
    public static ApprovalMapper INSTANCE = Mappers.getMapper(ApprovalMapper.class);

    public abstract List<Approval> approversToApprovals(List<Approver> approvers);

    @Mapping(target = "approver", source = "approver")
    public abstract Approval approverToApproval(Approver approver);

}
