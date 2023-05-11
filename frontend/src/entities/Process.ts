interface Process {
  id: String;
  links?: Links[];
  definitionId: String;
  businessKey: String;
  caseInstanceId: String;
  ended: Boolean;
  suspended: Boolean;
  tenantID: String;
}

interface Links {
  method: String;
  href: String;
  rel: String;
}

export default Process;
