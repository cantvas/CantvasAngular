export class Assignment {
  id: number;
  name: string;
  document: string;
  maxValue: number;

  constructor(id: number, name: string, document: string, maxValue: number) {
    this.id = id;
    this.name = name;
    this.document = document;
    this.maxValue = maxValue;
  }
}
