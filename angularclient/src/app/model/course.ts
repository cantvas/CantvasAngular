import { Teacher } from "./teacher";

export class Course {
  id: number
  name: string
  teacher: Teacher[] = [];

  constructor(id:number, name: string){
    this.id = id;
    this.name = name;
  }
}
