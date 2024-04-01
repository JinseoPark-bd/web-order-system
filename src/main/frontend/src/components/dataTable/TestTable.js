import { Card, Typography } from "@material-tailwind/react";
 
const TABLE_HEAD = ["No", "수량", "제품코드", "제품명", "영문명", ""];
 
const TABLE_ROWS = [
  {
    no: "1",
    quantity: "100",
    code: "A123456",
    name: "박카스",
    enName:"abcdefg",
  },
  {
    no: "2",
    quantity: "100",
    code: "A123456",
    name: "박카스",
    enName:"abcdefg",
  },
  {
    no: "3",
    quantity: "100",
    code: "A123456",
    name: "박카스",
    enName:"abcdefg",
  },
  {
    no: "4",
    quantity: "100",
    code: "A123456",
    name: "박카스",
    enName:"abcdefg",
  },
  {
    no: "5",
    quantity: "100",
    code: "A123456",
    name: "박카스",
    enName:"abcdefg",
  },
];
 
export function TestTable() {



  return ( 
    <Card className="h-full w-full overflow-scroll">
      <table className="w-full min-w-max table-auto text-left">
        <thead>
          <tr>
            {TABLE_HEAD.map((head) => (
              <th key={head} className="border-b border-blue-gray-100 bg-blue-gray-50 p-4">
                <Typography
                  variant="small"
                  color="blue-gray"
                  className="font-normal leading-none opacity-70"
                >
                  {head}
                </Typography>
              </th>
            ))}
          </tr>
        </thead>
        <tbody>
          {TABLE_ROWS.map(({ no, quantity, code, name, enName }, index) => (
            <tr key={name} className="even:bg-blue-gray-50/50">
              <td className="p-4">
                <Typography variant="small" color="blue-gray" className="font-normal">
                  {no}
                </Typography>
              </td>
              <td className="p-4">
                <Typography variant="small" color="blue-gray" className="font-normal">
                  {quantity}
                </Typography>
              </td>
              <td className="p-4">
                <Typography variant="small" color="blue-gray" className="font-normal">
                  {code}
                </Typography>
              </td>
              <td className="p-4">
                <Typography variant="small" color="blue-gray" className="font-normal">
                  {name}
                </Typography>
              </td>
              <td className="p-4">
                <Typography variant="small" color="blue-gray" className="font-normal">
                  {enName}
                </Typography>
              </td>
              <td className="p-4">
                <Typography as="a" href="#" variant="small" color="blue-gray" className="font-medium">
                  삭제
                </Typography>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </Card>
  );
}